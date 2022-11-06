package CharacterCreator;

import CharacterCreator.DnDClass.CharacterClass;
import CharacterCreator.DnDClass.ClassFactory;
import CharacterCreator.DnDRace.GnomeFactory;
import CharacterCreator.DnDRace.HalfOrcFactory;
import CharacterCreator.DnDRace.RaceFactory;
import CharacterCreator.Visitor.ElementVisitor;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class VisitorPatternDemo {
    public static void main(String[] args) throws IOException {

        ElementVisitor visitor = new ElementVisitor();
        TreeMap js = new TreeMap<>();
        JSONObject jo = new JSONObject();
        FileWriter fw = new FileWriter("output.json");

        Character player1 = new Character("Garrick", ClassFactory.getClass("Fighter"),
                RaceFactory.getRace(new GnomeFactory(), "Gnome"));
        player1.setAttributes(Stats.generate());

        visitor.visit(player1, js);
        visitor.visit(player1.getDndclass(), js);
        visitor.visit(player1.getRace(), js);
        visitor.visit(player1.getAttributes(), js);

        jo.putAll(js);

        fw.write('[');
        fw.write(jo.toJSONString());
        fw.write(']');

        fw.close();
    }
}
