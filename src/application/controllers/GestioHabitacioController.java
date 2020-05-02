package application.controllers;

import application.models.Database;
import application.models.Habitacio;
import application.models.Usuari;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class GestioHabitacioController {

    @FXML
    private TableView<Habitacio> tablaHabitacio;

    @FXML
    private TableColumn<Habitacio, Integer> id_column;

    @FXML
    private TableColumn<Habitacio, Integer> planta_column;

    @FXML
    private TableColumn<Habitacio, Integer> preu_column;

    @FXML
    private TableColumn<Habitacio, String> estat_column;

    @FXML
    private TableColumn<Habitacio, String> tipus_column;

    @FXML
    private TableColumn<Habitacio, String> descripcio_column;

    @FXML
    private TableColumn<Habitacio, String> caracteristiques_column;

    @FXML
    private TextField filtroHabitacio;

    @FXML
    private Button editarHabitacio_btn;

    @FXML
    private Button eliminarHabitacio_btn;
    
    @FXML
    private Button afegirHabitacio_btn;

    @FXML
    void buscarHabitacio(KeyEvent event) {
    	tablaHabitacio.setItems(db.getHabitacions(filtroHabitacio.getText()));
    }

    @FXML
    void editarHabitacio(ActionEvent event) {
    	System.out.println("Editando...");
    }

    @FXML
    void eliminarHabitacio(ActionEvent event) {
    	System.out.println("Eliminando...");
    }
    
    @FXML
    void afegirHabitacio(ActionEvent event) {
    	System.out.println("Afegint...");
    }
    
    private Database db = Database.getDatabase();
    
    @FXML
	void initialize() {
    	id_column.setCellValueFactory(new PropertyValueFactory<Habitacio, Integer>("id_habitacio"));
    	planta_column.setCellValueFactory(new PropertyValueFactory<Habitacio, Integer>("planta"));
    	preu_column.setCellValueFactory(new PropertyValueFactory<Habitacio, Integer>("preu"));
    	estat_column.setCellValueFactory(new PropertyValueFactory<Habitacio, String>("tipus"));
    	tipus_column.setCellValueFactory(new PropertyValueFactory<Habitacio, String>("tipus"));
    	descripcio_column.setCellValueFactory(new PropertyValueFactory<Habitacio, String>("descripcio"));
    	caracteristiques_column.setCellValueFactory(new PropertyValueFactory<Habitacio, String>("caracteristiques"));
    	
    	tablaHabitacio.setItems(db.getHabitacions());
    }

}
