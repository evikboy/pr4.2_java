package CharacterCreator;

import CharacterCreator.DnDClass.ClassFactory;
import CharacterCreator.DnDRace.GnomeFactory;
import CharacterCreator.DnDRace.RaceFactory;

public class FactoryMethodDemo {
    public static void main(String[] args) {

        Character player1 = new Character("Arthur", ClassFactory.getClass("Fighter"),
                RaceFactory.getRace(new GnomeFactory(), "Gnome"));
        player1.setAttributes(Stats.generate());
        player1.printSheet();

        ClassFactory.getClass("Fighter").printMagika();



        Character player2 = new Character("Ozan", ClassFactory.getClass("Bard"),
                RaceFactory.getRace(new GnomeFactory(), "Gnome"));
        player2.setAttributes(Stats.generate());
        player2.printSheet();

        ClassFactory.getClass("Bard").printMagika();
    }

}
