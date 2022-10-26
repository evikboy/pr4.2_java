package CharacterCreator;

import CharacterCreator.DnDClass.CharacterClass;

public class Character {
    private String name;
    private CharacterClass dndclass;

    private Stats attributes;

    public Character(String name, CharacterClass dndclass) {
        this.name = name;
        this.dndclass = dndclass;
    }

    public void setAttributes(Stats attributes) {
        this.attributes = attributes;
    }

    public void printSheet() {
        System.out.println("\n\nCharacter { "
                + "name: '" + this.name + '\''
                + ", " + this.dndclass
                + " } "
        );
        attributes.print();
    }
}
