package application.controllers;

import application.models.Database;
import application.models.Habitacio;
import application.models.Producte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class GestioProducteController {

    @FXML
    private TableView<Producte> tablaProducte;

    @FXML
    private TableColumn<Producte, Integer> id_servei;

    @FXML
    private TableColumn<Producte, String> nom_column;

    @FXML
    private TableColumn<Producte, Integer> preu_column;

    @FXML
    private TextField filtroProductes;

    @FXML
    private Button editarProducte_btn;

    @FXML
    private Button eliminarProducte_btn;

    @FXML
    private Button afegirProducte_btn;

    @FXML
    void afegirProducte(ActionEvent event) {
    	System.out.println("Afegint...");
    }

    @FXML
    void buscarProductes(KeyEvent event) {
    	tablaProducte.setItems(db.getProductes(filtroProductes.getText()));
    }

    @FXML
    void editarProducte(ActionEvent event) {
    	System.out.println("Editando...");
    }

    @FXML
    void eliminarProducte(ActionEvent event) {
    	System.out.println("Eliminando...");
    }
    
private Database db = Database.getDatabase();
    
    @FXML
	void initialize() {
    	id_servei.setCellValueFactory(new PropertyValueFactory<Producte, Integer>("id_servei"));
    	nom_column.setCellValueFactory(new PropertyValueFactory<Producte, String>("nom"));
    	preu_column.setCellValueFactory(new PropertyValueFactory<Producte, Integer>("preu"));
    	
    	tablaProducte.setItems(db.getProductes());
    }

}
