package CharacterCreator;

import CharacterCreator.DnDClass.CharacterClass;
import CharacterCreator.DnDRace.CharacterRace;
import CharacterCreator.Visitor.DataElement;
import CharacterCreator.Visitor.DataElementsVisitor;
import CharacterCreator.Visitor.ElementVisitor;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class Character implements DataElement {
    private String name;
    private CharacterClass dndclass;
    private CharacterRace race;
    private Stats attributes;

    public Character(String name, CharacterClass dndclass, CharacterRace race) {
        this.name = name;
        this.dndclass = dndclass;
        this.race = race;
    }

    public void setAttributes(Stats attributes) {
        this.attributes = attributes;
    }

    public void printSheet() {
        System.out.println("\n\nCharacter { "
                + "name: '" + this.name + '\''
                + ", " + this.dndclass
                + ", " + this.race
                + " } "
        );
        attributes.print();
    }


    public void addRaceBonuses() {
        System.out.print("\n\n!!!Recalculating attributes for ");
        this.race.print();

        attributes.setStrength(attributes.getStrength() + race.getRaceBonuses().getStrength());
        attributes.setDexterity(attributes.getDexterity() + race.getRaceBonuses().getDexterity());
        attributes.setConstitution(attributes.getConstitution() + race.getRaceBonuses().getConstitution());
        attributes.setIntellect(attributes.getIntellect() + race.getRaceBonuses().getIntellect());
        attributes.setWisdom(attributes.getWisdom() + race.getRaceBonuses().getWisdom());
        attributes.setCharisma(attributes.getCharisma() + race.getRaceBonuses().getCharisma());
    }

    public void talk() {
        System.out.print("Talk(): ");
        race.saySMTH();
    }

    public String getName() {
        return name;
    }


    public CharacterClass getDndclass() {
        return dndclass;
    }

    public CharacterRace getRace() {
        return race;
    }

    public Stats getAttributes() {
        return attributes;
    }

    @Override
    public void accept(DataElementsVisitor v) {
        v.visit(this);
    }
}
