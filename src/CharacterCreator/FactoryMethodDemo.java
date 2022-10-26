package CharacterCreator;

import CharacterCreator.DnDClass.ClassFactory;

public class FactoryMethodDemo {
    public static void main(String[] args) {

        Character player1 = new Character("Arthur", ClassFactory.getClass("Fighter"));
        player1.setAttributes(Stats.generate());
        player1.printSheet();

        ClassFactory.getClass("Fighter").printMagika();



        Character player2 = new Character("Ozan", ClassFactory.getClass("Bard"));
        player2.setAttributes(Stats.generate());
        player2.printSheet();

        ClassFactory.getClass("Bard").printMagika();
    }

}
