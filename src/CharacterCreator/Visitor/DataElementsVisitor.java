package CharacterCreator.Visitor;

import CharacterCreator.Character;
import CharacterCreator.DnDClass.CharacterClass;
import CharacterCreator.DnDRace.CharacterRace;
import CharacterCreator.Stats;

public interface DataElementsVisitor {
    public void visit(Character character);
    public void visit(Stats stats);
    public void visit(CharacterRace characterRace);
    public void visit(CharacterClass characterClass);
}
