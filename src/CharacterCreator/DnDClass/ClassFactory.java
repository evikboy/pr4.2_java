package CharacterCreator.DnDClass;

public class ClassFactory {

    public static CharacterClass getClass(String type) {
       if ("Fighter".equalsIgnoreCase(type)) return new Fighter();
       else if ("Bard".equalsIgnoreCase(type)) return new Bard();
       return null;
    }
}
