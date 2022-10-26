package CharacterCreator.DnDClass;

public abstract class CharacterClass {
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
}
