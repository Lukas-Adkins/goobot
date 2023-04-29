/*
 * Java source file for CeresBot.
 * @Author Lukas Adkins
 */

package goobot.model.starlight;

import goobot.Constants.StItemType;
import goobot.Constants.StRarity;

import java.util.Objects;

public class StMeleeWeapon extends StItem {
    
    private String weaponTypes;
    private String range;
    private String dmg;
    private String pen;

    public StMeleeWeapon(StItemType type, String name, StRarity rarity, String description, String weight, Integer price, String weaponTypes, String range, String dmg, String pen) {
        super(type, name, rarity, description, weight, price);
        this.weaponTypes = weaponTypes;
        this.range = range;
        this.dmg = dmg;
        this.pen = pen;
    }

    public String getWeaponTypes() {
        return this.weaponTypes;
    }

    public void setWeaponTypes(String weaponTypes) {
        this.weaponTypes = weaponTypes;
    }

    public String getRange() {
        return this.range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getDmg() {
        return this.dmg;
    }

    public void setDmg(String dmg) {
        this.dmg = dmg;
    }

    public String getPen() {
        return this.pen;
    }

    public void setPen(String pen) {
        this.pen = pen;
    }

    public StMeleeWeapon weaponTypes(String weaponTypes) {
        setWeaponTypes(weaponTypes);
        return this;
    }

    public StMeleeWeapon range(String range) {
        setRange(range);
        return this;
    }

    public StMeleeWeapon dmg(String dmg) {
        setDmg(dmg);
        return this;
    }

    public StMeleeWeapon pen(String pen) {
        setPen(pen);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StMeleeWeapon)) {
            return false;
        }
        StMeleeWeapon dhMeleeWeapon = (StMeleeWeapon) o;
        return Objects.equals(weaponTypes, dhMeleeWeapon.weaponTypes) && Objects.equals(range, dhMeleeWeapon.range) && Objects.equals(dmg, dhMeleeWeapon.dmg) && Objects.equals(pen, dhMeleeWeapon.pen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weaponTypes, range, dmg, pen);
    }

    @Override
    public String toString() {
        return String.format("```ansi\n%s / %s / %d credits /\nRange: %s / Damage: %s / Pen: %s \n%s```", getName(), getFormattedRarity(), getPrice(), range , dmg, pen, getDescription());
    }
}