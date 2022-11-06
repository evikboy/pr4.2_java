package CharacterCreator;

import CharacterCreator.Visitor.DataElement;
import CharacterCreator.Visitor.DataElementsVisitor;

import java.util.Map;
import java.util.TreeMap;

public class Stats implements DataElement {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intellect;
    private int wisdom;
    private int charisma;

    public Stats(int strength, int dexterity, int constitution, int intellect, int wisdom, int charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intellect = intellect;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public Stats(){}

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public Map getMapAttributes() {
        Map<String, Integer> attr = new TreeMap<>();
        attr.put("Strength", this.strength);
        attr.put("Dexterity", this.dexterity);
        attr.put("Constitution", this.constitution);
        attr.put("Intellect", this.intellect);
        attr.put("Wisdom", this.wisdom);
        attr.put("Charisma", this.charisma);
        return attr;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public static Stats generate() {
         return new Stats(Dice.rollStat(), Dice.rollStat(), Dice.rollStat(),
                 Dice.rollStat(), Dice.rollStat(), Dice.rollStat());
    }

    public void print() {
        System.out.println(
                "Strength: " + this.strength
                + "\nDexterity: " + this.dexterity
                + "\nConstitution: " + this.constitution
                + "\nIntellect: " + this.intellect
                + "\nWisdom: " + this.wisdom
                + "\nCharisma: " + this.charisma);
    }

    @Override
    public Object accept(DataElementsVisitor v, TreeMap js) {
        return v.visit(this, js);
    }
}
