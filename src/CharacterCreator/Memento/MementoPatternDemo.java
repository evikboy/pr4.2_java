package CharacterCreator.Memento;

import CharacterCreator.DnDClass.CharacterClass;
import CharacterCreator.DnDClass.ClassFactory;
import CharacterCreator.DnDRace.GnomeFactory;
import CharacterCreator.DnDRace.RaceFactory;
import CharacterCreator.Stats;
import CharacterCreator.Character;

public class MementoPatternDemo {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Originator originator = new Originator();

        Character player = new Character("Arthur", ClassFactory.getClass("Fighter"),
                RaceFactory.getRace(new GnomeFactory(), "Gnome"));


        System.out.println("\n-----------------------------------" +
                "Saving states stage" +
                "-----------------------------------");

        Stats stats = Stats.generate();

        player.setAttributes(stats);
        player.printSheet();

        originator.setState(stats);
        careTaker.add(originator.saveStateToMemento());


        System.out.println("!!!Regenerate...");


        stats = Stats.generate();

        player.setAttributes(stats);
        player.printSheet();

        originator.setState(stats);
        careTaker.add(originator.saveStateToMemento());


        System.out.println("!!!Regenerate...");


        stats = Stats.generate();

        player.setAttributes(stats);
        player.printSheet();

        originator.setState(stats);
        careTaker.add(originator.saveStateToMemento());


        System.out.println("\n-----------------------------------" +
                "Loading state stage" +
                "-----------------------------------\n");

        originator.getStateFromMemento(careTaker.get(0).getState());
        stats = originator.getState();

        player.setAttributes(stats);
        player.printSheet();
    }
}