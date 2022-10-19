public class Character {
    private String name;
    private String dndclass;
    private Stats attributes;

    public Character(String name, String dndclass) {
        this.name = name;
        this.dndclass = dndclass;
    }

    public void setAttributes(Stats attributes) {
        this.attributes = attributes;
    }

    public void printSheet() {
        System.out.println("\nCharacter{"
                + "name='" + this.name + '\''
                + ", dndclass='" + this.dndclass + '\''
                + "}"
        );
        attributes.print();
    }
}
