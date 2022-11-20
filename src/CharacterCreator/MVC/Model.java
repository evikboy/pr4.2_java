package CharacterCreator.MVC;

import CharacterCreator.Character;
import CharacterCreator.DnDClass.ClassFactory;
import CharacterCreator.DnDRace.*;
import CharacterCreator.Memento.CareTaker;
import CharacterCreator.Memento.Originator;
import CharacterCreator.Stats;
import CharacterCreator.Visitor.ElementVisitor;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Model {

    public static  Model getInst() {
        return inst;
    }

    private static Model inst=new Model();
    private List<Character> items = new ArrayList<>();

    private Character character;
    private Stats stats;
    private CareTaker careTaker;
    private Originator originator;

    private ElementVisitor visitor = new ElementVisitor();
    private JSONObject jo = new JSONObject();


    public Character getItem(int i) {
        return items.get(i);
    }

    public List<Character> getItems() {
        return items;
    }

    public void addItem(Character cha) {
        items.add(cha);
    }

    public void deleteItem(int i) {
        items.remove(i);
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(String name, String race, String _class) {
        RaceAbstractFactory factory = null;

        if (race.contains("Gnome")){factory = new GnomeFactory();}
        else if (race.contains("Half-Orc")) {factory = new HalfOrcFactory();}
        this.character = new Character(name, ClassFactory.getClass(_class),
                RaceFactory.getRace(factory, race));
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public CareTaker getCareTaker() {
        return careTaker;
    }

    public void setCareTaker(CareTaker careTaker) {
        this.careTaker = careTaker;
    }

    public Originator getOriginator() {
        return originator;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }

    public JSONObject getJSONObject() {
        return jo;
    }

    public void setJSONObject(JSONObject jo) {
        this.jo = jo;
    }

    public ElementVisitor getVisitor() {
        return visitor;
    }

    public void setVisitor(ElementVisitor visitor) {
        this.visitor = visitor;
    }
}
