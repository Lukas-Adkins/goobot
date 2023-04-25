/*
 * Java source file for CeresBot.
 * @Author Lukas Adkins
 */

package goobot.model;

import java.util.Objects;

import goobot.Constants.DhItemType;

public class DhArmor extends DhItem {
    private String covers;
    private String AP;
    private String maxAgility;

    public DhArmor(DhItemType type, String name, String rarity, String description, String weight, Integer price, String covers, String AP, String maxAgility) {
        super(type, name, rarity, description, weight, price);
        this.covers = covers;
        this.AP = AP;
        this.maxAgility = maxAgility;
    }

    public String getCovers() {
        return this.covers;
    }

    public void setCovers(String covers) {
        this.covers = covers;
    }

    public String getAP() {
        return this.AP;
    }

    public void setAP(String AP) {
        this.AP = AP;
    }

    public String getMaxAgility() {
        return this.maxAgility;
    }

    public void setMaxAgility(String maxAgility) {
        this.maxAgility = maxAgility;
    }

    public DhArmor covers(String covers) {
        setCovers(covers);
        return this;
    }

    public DhArmor AP(String AP) {
        setAP(AP);
        return this;
    }

    public DhArmor maxAgility(String maxAgility) {
        setMaxAgility(maxAgility);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DhArmor)) {
            return false;
        }
        DhArmor dhArmor = (DhArmor) o;
        return Objects.equals(covers, dhArmor.covers) && Objects.equals(AP, dhArmor.AP) && Objects.equals(maxAgility, dhArmor.maxAgility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(covers, AP, maxAgility);
    }

    @Override
    public String toString(){
        return String.format("```ansi\n%s / %s / %d credits /\nCovers: %s / AP: %s / Max Agility: %s\n%s```", getName(), getFormattedRarity(), getPrice(), covers , AP, maxAgility, getDescription());
    }

}
