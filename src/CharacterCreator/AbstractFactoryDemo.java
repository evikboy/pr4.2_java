package CharacterCreator;

import CharacterCreator.DnDClass.ClassFactory;
import CharacterCreator.DnDRace.*;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        Character player1 = new Character("Garrick", ClassFactory.getClass("Fighter"),
                RaceFactory.getRace(new GnomeFactory(), "Gnome"));
        player1.setAttributes(Stats.generate());

        player1.printSheet();
        player1.addRaceBonuses();
        player1.printSheet();
        player1.talk();
    }


}
