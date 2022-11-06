package CharacterCreator.Visitor;

public interface DataElement {
    public void accept(DataElementsVisitor v);
}
