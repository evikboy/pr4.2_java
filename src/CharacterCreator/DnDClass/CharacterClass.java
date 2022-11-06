package CharacterCreator.DnDClass;

import CharacterCreator.Visitor.DataElement;
import CharacterCreator.Visitor.DataElementsVisitor;

import java.util.TreeMap;

public abstract class CharacterClass implements DataElement {
    protected String name;
    protected int hp;

    public abstract void printMagika();

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        String out = "class: " + '\'' + name + '\''
                + ", HP: " + hp;
        return out;
    }

    public String getName() {
        return name;
    }

    @Override
    public Object accept(DataElementsVisitor v, TreeMap js) {
        return v.visit(this, js);
    }
}
