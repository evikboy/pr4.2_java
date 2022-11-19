package CharacterCreator.MVC;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private ChoiceBox<String> choiceRace;

    @FXML ChoiceBox<String> choiceClass;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceRace.setValue("Gnome");
        choiceRace.getItems().add("Gnome");
        choiceRace.getItems().add("Half-Orc");

        choiceClass.setValue("Fighter");
        choiceClass.getItems().add("Fighter");
        choiceClass.getItems().add("Bard");






    }





}