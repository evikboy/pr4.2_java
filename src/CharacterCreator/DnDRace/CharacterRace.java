package CharacterCreator.DnDRace;

import CharacterCreator.Stats;

public abstract class CharacterRace {
    protected String name;
    protected Stats bonuses;

    public abstract void saySMTH();

    public Stats getRaceBonuses() {
        return bonuses;
    }

    @Override
    public String toString() {
        String out = "race: " + '\'' + name + '\'';
        return out;
    }

    public void print() {
        System.out.println("race: " + '\'' + name + '\'');

        if (bonuses.getStrength() > 0) {
            System.out.println("strength+" + bonuses.getStrength());
        }

        if (bonuses.getDexterity() > 0) {
            System.out.println("dexterity+" + bonuses.getDexterity());
        }

        if (bonuses.getConstitution() > 0) {
            System.out.println("constitution+" + bonuses.getConstitution());
        }

        if (bonuses.getIntellect() > 0) {
            System.out.println("intellect+" + bonuses.getIntellect());
        }

        if (bonuses.getWisdom() > 0) {
            System.out.println("wisdom+" + bonuses.getWisdom());
        }

        if (bonuses.getCharisma() > 0) {
            System.out.println("charisma+" + bonuses.getCharisma());
        }
    }
}
