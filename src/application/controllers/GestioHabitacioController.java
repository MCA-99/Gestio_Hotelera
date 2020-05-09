package application.controllers;

import com.jfoenix.controls.JFXButton;

import application.models.Database;
import application.models.Habitacio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class GestioHabitacioController {
	private Database db = Database.getDatabase();
    @FXML
    private TextField filtreHabitacio;

    @FXML
    private TableView<Habitacio> tablaHabitacio;

    @FXML
    private TableColumn<Habitacio, Integer> id_column;

    @FXML
    private TableColumn<Habitacio, Integer> planta_column;

    @FXML
    private TableColumn<Habitacio, Float> preu_column;

    @FXML
    private TableColumn<Habitacio, String> estat_column;

    @FXML
    private TableColumn<Habitacio, String> tipus_column;

    @FXML
    private TableColumn<Habitacio, String> descripcio_column;

    @FXML
    private TableColumn<Habitacio, String> caracteristiques_column;

    @FXML
    private JFXButton editarHabitacio_btn;

    @FXML
    private JFXButton afegir_btn;
    
    @FXML
    private Label error;

    @FXML
    void afegir(ActionEvent event) {

    }

    @FXML
    void buscarRecepcionista(KeyEvent event) {

    }

    @FXML
    void editarHabitacio(ActionEvent event) {
    	tablaHabitacio.setItems(db.getHabitacions(filtreHabitacio.getText()));
    }
    
    @FXML
	void initialize() {
    	id_column.setCellValueFactory(new PropertyValueFactory<Habitacio, Integer>("id_habitacio"));
    	planta_column.setCellValueFactory(new PropertyValueFactory<Habitacio, Integer>("planta"));
    	preu_column.setCellValueFactory(new PropertyValueFactory<Habitacio, Float>("preu"));
    	estat_column.setCellValueFactory(new PropertyValueFactory<Habitacio, String>("tipus"));
    	tipus_column.setCellValueFactory(new PropertyValueFactory<Habitacio, String>("tipus"));
    	descripcio_column.setCellValueFactory(new PropertyValueFactory<Habitacio, String>("descripcio"));
    	caracteristiques_column.setCellValueFactory(new PropertyValueFactory<Habitacio, String>("caracteristiques"));
    	
    	tablaHabitacio.setItems(db.getHabitacions());
    }

}
