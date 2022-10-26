package CharacterCreator.DnDClass;

public class Fighter extends CharacterClass {
    private String perk;

    public Fighter() {
        this.name = "Fighter";
        this.hp = 10;
        this.perk = "Extra Attack";
    }

    @Override
    public void printMagika() {
        System.out.println("Class " + name + " has: "
                + "\"" + perk + "\"");
    }
}
