package CharacterCreator.Visitor;

import CharacterCreator.Character;
import CharacterCreator.DnDClass.CharacterClass;
import CharacterCreator.DnDRace.CharacterRace;
import CharacterCreator.Stats;

import java.util.Set;

public class ElementVisitor implements DataElementsVisitor {
    @Override
    public void visit(Character character) {
        System.out.println("!Visited Character");
        System.out.println("Name: "+character.getName());
    }

    @Override
    public void visit(Stats stats) {
        System.out.println("!Visited Stats");
        stats.print();

    }

    @Override
    public void visit(CharacterRace characterRace) {
        System.out.println("!Visited CharacterRace");
        System.out.println("Race: "+characterRace.getName());
    }

    @Override
    public void visit(CharacterClass characterClass) {
        System.out.println("!Visited CharacterClass");
        System.out.println("Class: "+characterClass.getName());
        System.out.println("HP: "+characterClass.getHp());
    }
}
