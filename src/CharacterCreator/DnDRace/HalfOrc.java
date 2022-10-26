package CharacterCreator.DnDRace;

import CharacterCreator.Stats;

public class HalfOrc extends CharacterRace{

    public HalfOrc(String name, Stats stats) {
        this.name = name;
        this.bonuses = stats;
    }

    @Override
    public void saySMTH() {
        System.out.println("I don't trust in pretty things. They often hide an ugliness inside");
    }
}
