/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package goobot;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.events.*;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Collections;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.ChannelType; 
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class App extends ListenerAdapter {
    public static final boolean LOG_MESSAGES = true;
    public static final String BOT_PREFIX = "!";
    public CommandController commandController = new CommandController();

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String discordToken = dotenv.get("DISCORD_API_KEY");
        JDA jda = null;

        try{
            jda = JDABuilder.createDefault(discordToken)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT) // enables explicit access to message.getContentDisplay()
                .build();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        if(jda != null){
            System.out.println("Adding event listener.");
            jda.addEventListener(new App());
        }
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if(LOG_MESSAGES) {
            if (event.isFromType(ChannelType.PRIVATE)) {
                System.out.printf("[PM] %s: %s\n", event.getAuthor().getName(),
                                        event.getMessage().getContentDisplay());
            }
            else {
                System.out.printf("[%s] %s: %s\n", event.getGuild().getName(),
                            event.getMember().getEffectiveName(),
                            event.getMessage().getContentDisplay());
            }
        }
            
        // We don't want to respond to other bot accounts, including ourself
        if(event.getAuthor().isBot()) return;
        Message message = event.getMessage();
        String content = message.getContentRaw();
        // Sees if message contains the command prefix
        if(content.substring(0, 1).equalsIgnoreCase(BOT_PREFIX))
            // Strips message of command prefix and sends to parse
            parseCommand(content.substring(1), event);
    }

    /**
     * Processes the command sent to the bot.
     * @param fullCommand Command text without the prefix ('!')
     */
    public void parseCommand(String fullCommand, @Nonnull MessageReceivedEvent event){
        String command, args;
        MessageChannel channel = event.getChannel();
        int index = fullCommand.indexOf(' ');
    
        System.out.println("Recieved fullCommand: " + fullCommand);
        if(index > -1) { // If there is more than one word.
            command = fullCommand.substring(0, index).trim().toLowerCase(); // Extract first word
            args = fullCommand.substring(index).trim().toLowerCase(); // Extract remaining words
        }
        else{ // There is only one word
            command = fullCommand.toLowerCase();
            args = "";
        }

        switch(command){
            case "help":
                post(commandController.Help(args), channel);
                break;
            case "ping":
                post(commandController.Ping(args), channel);
                break;
            case "spell":
                post(commandController.Spell(args), channel);
                break; 
            case "spellscroll":
                post(commandController.SpellScroll(args), channel);
                break;
            default:
                System.out.println("Unknown command: " + command + " with arguments: " + args);
        }
    }

    public void post(String message, MessageChannel channel){
        if(message.length() > 2000)
            message = message.substring(0, 1997) + "...";
        try{
            channel.sendMessage(message).queue();
        }
        catch(Exception e){
            System.err.println(e);
        }
    }
}
