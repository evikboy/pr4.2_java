package CharacterCreator.DnDClass;

import java.util.ArrayList;
import java.util.List;

public class Bard extends CharacterClass{
    private List<String> spells = new ArrayList<>();

    public Bard() {
        this.name = "Bard";
        this.hp = 8;
        this.spells.add("Charm Person");
        this.spells.add("Heroism");
    }

    @Override
    public void printMagika() {
        System.out.println("Class " + name + " knows spells: ");
        for (String spell: spells) {
            System.out.println("\"" + spell + "\"");
        }

    }
}
