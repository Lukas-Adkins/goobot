# Ceresbot

A helpful Discord bot for looking up D&D-related data.

**Setup**

1. Ensure you have Java and Gradle installed.
2. `git clone` the project.
3. Create an `.env` file in the project root directory, and set an enviroment variable called `DISCORD_API_KEY` equal to your Discord bot API key. 
4. Add D&D spells to a .json file using the schema outlined in spells_test.json
5. Add D&D characters to .csv file using the schema outlined in characters_test.json
6. Ensure that the filepaths in Constants.java match your resource files
7. In your terminal, run the `gradle run` command.

**Current commands**
      
`!roll <number of dice>d<dice> <+/-> <modifier>` - Simulates a dice roll for the specified dice values.    
`!spell <spell>` - Provides information on the given 5e D&D spell.  
`!spellscroll <spell>` - Calculates the price of a spell scroll for the given 5e D&D spell.  
`!character <character name>` - Displays information about a matching D&D character.
