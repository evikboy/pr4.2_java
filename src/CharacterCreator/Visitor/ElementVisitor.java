package CharacterCreator.Visitor;

import CharacterCreator.Character;
import CharacterCreator.DnDClass.CharacterClass;
import CharacterCreator.DnDRace.CharacterRace;
import CharacterCreator.Stats;

import java.util.Set;
import java.util.TreeMap;

public class ElementVisitor implements DataElementsVisitor {
    @Override
    public Object visit(Character character, TreeMap js) {
        js.put("Name", character.getName());
        return js;
    }

    @Override
    public Object visit(Stats stats, TreeMap js) {
        js.put("Attributes", stats.getMapAttributes());
        return js;
    }

    @Override
    public Object visit(CharacterRace characterRace, TreeMap js) {
        js.put("Race", characterRace.getName());
        return js;
    }

    @Override
    public Object visit(CharacterClass characterClass, TreeMap js) {
        js.put("Class", characterClass.getName());
        js.put("HP", characterClass.getHp());
        return js;
    }
}
