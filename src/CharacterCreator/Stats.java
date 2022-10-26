package CharacterCreator;

public class Stats {
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

    public static Stats generate() {
         return new Stats(Dice.rollStat(), Dice.rollStat(), Dice.rollStat(),
                 Dice.rollStat(), Dice.rollStat(), Dice.rollStat());
    }

    public void print() {
        System.out.println("~~~~~~~~~~Character attributes~~~~~~~~~~"
                + "\nStrength: " + this.strength
                + "\nDexterity: " + this.dexterity
                + "\nConstitution: " + this.constitution
                + "\nIntellect: " + this.intellect
                + "\nWisdom: " + this.wisdom
                + "\nCharisma: " + this.charisma
                + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

}
