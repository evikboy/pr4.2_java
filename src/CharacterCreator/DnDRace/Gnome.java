package CharacterCreator.DnDRace;

import CharacterCreator.Stats;

public class Gnome extends CharacterRace{

    public Gnome(String name, Stats stats) {
        this.name = name;
        this.bonuses = stats;
    }

    @Override
    public void saySMTH() {
        System.out.println("I love to stand in gardens for hours at a time");
    }
}
