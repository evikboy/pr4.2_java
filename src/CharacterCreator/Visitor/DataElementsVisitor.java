package CharacterCreator.Visitor;

import CharacterCreator.Character;
import CharacterCreator.DnDClass.CharacterClass;
import CharacterCreator.DnDRace.CharacterRace;
import CharacterCreator.Stats;

import java.util.TreeMap;

public interface DataElementsVisitor {
    public Object visit(Character character, TreeMap js);
    public Object visit(Stats stats, TreeMap js);
    public Object visit(CharacterRace characterRace, TreeMap js);
    public Object visit(CharacterClass characterClass, TreeMap js);
}
