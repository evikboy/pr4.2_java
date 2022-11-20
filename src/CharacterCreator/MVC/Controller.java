package CharacterCreator.MVC;


import CharacterCreator.Character;
import CharacterCreator.Memento.CareTaker;
import CharacterCreator.Memento.Originator;
import CharacterCreator.Visitor.DataElement;
import CharacterCreator.Visitor.ElementVisitor;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import CharacterCreator.Stats;


public class Controller implements Initializable {
    private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    private Date date;
    private static Model mode = Model.getInst();
    private static int it = 0;

    @FXML
    private TextField nameCha_field;
    @FXML
    private ChoiceBox<String> choiceRace;
    @FXML
    private ChoiceBox<String> choiceClass;

    @FXML
    private TextField str_field;
    @FXML
    private TextField dex_field;
    @FXML
    private TextField con_field;
    @FXML
    private TextField int_field;
    @FXML
    private TextField cha_field;
    @FXML
    private TextField wis_field;

    @FXML
    private Button saveButton;
    @FXML
    private Button returnButton;

    @FXML
    private Button createCharacterButton;

    @FXML
    private ListView<String> listCharacters;

    @FXML
    private ListView<String> listHistory;

    @FXML
    private Button saveJSONButton;

    @FXML
    private TextArea jsonTextArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceRace.setValue("Gnome");
        choiceRace.getItems().add("Gnome");
        choiceRace.getItems().add("Half-Orc");

        choiceClass.setValue("Fighter");
        choiceClass.getItems().add("Fighter");
        choiceClass.getItems().add("Bard");
    }

    @FXML
    public void onGenerateButtonClick() {
        saveButton.setDisable(false);
        returnButton.setDisable(false);
        mode.setStats(Stats.generate());

        str_field.setText(mode.getStats().getMapAttributes().get("Strength").toString());
        dex_field.setText(mode.getStats().getMapAttributes().get("Dexterity").toString());
        con_field.setText(mode.getStats().getMapAttributes().get("Constitution").toString());
        int_field.setText(mode.getStats().getMapAttributes().get("Intellect").toString());
        cha_field.setText(mode.getStats().getMapAttributes().get("Charisma").toString());
        wis_field.setText(mode.getStats().getMapAttributes().get("Wisdom").toString());
    }

    @FXML
    public void onCreateCharacterButtonClick() {
        date = new Date();

        if (mode.getStats() != null) {
            if (nameCha_field.getText().length() != 0) {
                if (it < 5) {
                    String name = nameCha_field.getText();
                    String race = choiceRace.getValue();
                    String _class = choiceClass.getValue();

                    mode.setCharacter(name, race, _class);
                    mode.getCharacter().setAttributes(mode.getStats());
//        mode.getCharacter().addRaceBonuses();

                    listCharacters.getItems().add(race+ "-" +_class + " " + name);

                    mode.addItem(mode.getCharacter());

                    listHistory.getItems().add(formatter.format(date) + " -> Character " +name+ " created!");
                    it++;
                }
                else {
                    listHistory.getItems().add(formatter.format(date) + " -> Only 5 characters is allowed");
                }
            }
            else {
                listHistory.getItems().add(formatter.format(date) + " -> Input character name");
            }
        }
        else {
            listHistory.getItems().add(formatter.format(date) + " -> Generate attributes before creating character");
        }
    }

    @FXML
    public void onDeleteButtonClick() {
        try {
            int index = listCharacters.getSelectionModel().getSelectedIndex();
            mode.deleteItem(index);
            listCharacters.getItems().remove(index);
            System.out.println("Deleted character: index=" + index);
            it--;
        }
        catch (IndexOutOfBoundsException e) {
            listHistory.getItems().add(formatter.format(date) + " -> Choose character to delete");
        }

    }

    @FXML
    public void onSaveButtonClick() {
        date = new Date();

        if (mode.getStats() != null) {
            mode.setCareTaker(new CareTaker());
            mode.setOriginator(new Originator());

            mode.getOriginator().setState(mode.getStats());
            mode.getCareTaker().add(mode.getOriginator().saveStateToMemento());
            listHistory.getItems().add(formatter.format(date) + " -> Attributes saved");
            saveButton.setDisable(true);
            returnButton.setDisable(true);
        }
        else {
            listHistory.getItems().add(formatter.format(date) + " -> Generate attributes before saving");
        }
    }

    @FXML
    public void onReturnButtonClick() {
        date = new Date();
        try {
            mode.getStats().undoSave(mode.getCareTaker().getLast());

            str_field.setText(mode.getStats().getMapAttributes().get("Strength").toString());
            dex_field.setText(mode.getStats().getMapAttributes().get("Dexterity").toString());
            con_field.setText(mode.getStats().getMapAttributes().get("Constitution").toString());
            int_field.setText(mode.getStats().getMapAttributes().get("Intellect").toString());
            cha_field.setText(mode.getStats().getMapAttributes().get("Charisma").toString());
            wis_field.setText(mode.getStats().getMapAttributes().get("Wisdom").toString());

            listHistory.getItems().add(formatter.format(date) + " -> Attributes returned");
            returnButton.setDisable(true);
            saveButton.setDisable(true);

        }
        catch (NullPointerException e) {
            listHistory.getItems().add(formatter.format(date) + " -> No save attributes found");
        }
    }

    @FXML
    public void onSaveJSONButtonClick() throws IOException {
        date = new Date();
        jsonTextArea.clear();

        if (mode.getItems().size() > 0) {
            String str = "[\n";
            for (Character character: mode.getItems()) {

                mode.getJSONObject().clear();

                mode.setVisitor(new ElementVisitor());

                TreeMap tm = new TreeMap();
                mode.getVisitor().visit(character, tm);
                mode.getVisitor().visit(character.getDndclass(), tm);
                mode.getVisitor().visit(character.getRace(), tm);
                mode.getVisitor().visit(character.getAttributes(), tm);

                mode.getJSONObject().putAll(tm);

                str += mode.getJSONObject().toJSONString();
                if(mode.getItems().indexOf(character)!=mode.getItems().size()-1){str+=",\n";}

            }
            str += "\n]";

            System.out.println(str);
            jsonTextArea.setText(str);

            FileWriter file = new FileWriter("output.json");
            file.write(str);
            file.close();
        }
        else {
            listHistory.getItems().add(formatter.format(date) + " -> Missing list of characters");
        }
    }
}