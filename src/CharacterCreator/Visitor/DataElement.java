package CharacterCreator.Visitor;

import java.util.TreeMap;

public interface DataElement {
    public Object accept(DataElementsVisitor v, TreeMap js);
}
