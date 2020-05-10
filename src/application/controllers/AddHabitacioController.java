package application.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.models.Habitacio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AddHabitacioController {
	private Habitacio addHabitacio;
    ObservableList<String> estat_list = FXCollections.observableArrayList("disponible","ocupada","en manteniment");
    ObservableList<String> tipus_list = FXCollections.observableArrayList("individual","doble","familiar");
    public AddHabitacioController() {
		this.addHabitacio = new Habitacio();
	}
	
    @FXML
    private JFXTextField preu;

    @FXML
    private JFXTextField planta;

    @FXML
    private JFXButton guardar_btn;

    @FXML
    private JFXComboBox<String> estat;

    @FXML
    private JFXComboBox<String> tipus;

    @FXML
    private JFXTextArea descripcio;

    @FXML
    private JFXTextArea caracteristiques;

    @FXML
    private Label error;

    @FXML
    void guardar(ActionEvent event) {
    	if(!planta.getText().isEmpty() && !preu.getText().isEmpty() && !estat.getSelectionModel().isEmpty() && !tipus.getSelectionModel().isEmpty() && !descripcio.getText().isEmpty() && !caracteristiques.getText().isEmpty()){
    		error.setText("");
    		addHabitacio.insert(Integer.parseInt(planta.getText()), Float.parseFloat(preu.getText()), estat.getSelectionModel().getSelectedItem(), tipus.getSelectionModel().getSelectedItem(), descripcio.getText(), caracteristiques.getText());
        	Stage stage = (Stage) guardar_btn.getScene().getWindow();
        	stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
    	}else {
    		error.setText("Omple tots els camps.");
    	}
    }
    
    @FXML
    void initialize() {
    	estat.setItems(estat_list);
    	tipus.setItems(tipus_list);
    	estat.getSelectionModel().select("disponible");
    	tipus.getSelectionModel().select("individual");
    }

}
