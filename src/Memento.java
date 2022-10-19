public class Memento {
    private Stats state;
    private int strength, dexterity, constitution, intellect, wisdom, charisma;

    public Memento(Stats stats) {
        this.state = stats;
        this.strength = stats.getStrength();
        this.dexterity = stats.getDexterity();
        this.constitution = stats.getConstitution();
        this.intellect = stats.getIntellect();
        this.wisdom = stats.getWisdom();
        this.charisma = stats.getCharisma();
    }

    public Stats getState() {
        return state;
    }
}
