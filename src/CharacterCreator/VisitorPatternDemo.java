package CharacterCreator;

import CharacterCreator.DnDClass.CharacterClass;
import CharacterCreator.DnDClass.ClassFactory;
import CharacterCreator.DnDRace.GnomeFactory;
import CharacterCreator.DnDRace.HalfOrcFactory;
import CharacterCreator.DnDRace.RaceFactory;
import CharacterCreator.Visitor.ElementVisitor;

public class VisitorPatternDemo {
    public static void main(String[] args) {

        ElementVisitor visitor = new ElementVisitor();
        Character player1 = new Character("Garrick", ClassFactory.getClass("Fighter"),
                RaceFactory.getRace(new GnomeFactory(), "Gnome"));
        player1.setAttributes(Stats.generate());


        visitor.visit(player1);
        visitor.visit(player1.getDndclass());
        visitor.visit(player1.getRace());
        visitor.visit(player1.getAttributes());
    }
}
