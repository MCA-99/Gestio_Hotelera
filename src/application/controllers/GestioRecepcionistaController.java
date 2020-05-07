package application.controllers;

import java.io.IOException;


import application.models.Database;
import application.models.Main;
import application.models.Usuari;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GestioRecepcionistaController {

    private Database db = Database.getDatabase();
    public Stage stage;
	@FXML
    private TableView<Usuari> tablaRecepcionista;
	
    @FXML
    private TableColumn<Usuari, Integer> id_column;

    @FXML
    private TableColumn<Usuari, String> nom_usuari_column;

    @FXML
    private TableColumn<Usuari, String> nom_column;

    @FXML
    private TableColumn<Usuari, String> cognom_column;

    @FXML
    private TableColumn<Usuari, String> segon_cognom_column;

    @FXML
    private TableColumn<Usuari, String> dni_column;

    @FXML
    private TableColumn<Usuari, String> passaport_column;

    @FXML
    private TableColumn<Usuari, String> nacionalitat_column;

    @FXML
    private TableColumn<Usuari, Integer> telefon_column;

    @FXML
    private TableColumn<Usuari, String> email_column;

    @FXML
    private TableColumn<Usuari, Boolean> activo_column;
    
    @FXML
    private TextField filtroRecepcionista;

    @FXML
    private Button editarRecepcionista_btn;

    @FXML
    private Button eliminarRecepcionista_btn;
    
    public static Usuari userEdit;
    
    @FXML
    void editarRecepcionista(ActionEvent event) {
    	
    	if (tablaRecepcionista.getSelectionModel().getSelectedItem() != null) {
    		userEdit = tablaRecepcionista.getSelectionModel().getSelectedItem();
    		try {
        		stage = new Stage();
        		Parent root = FXMLLoader.load(getClass().getResource("/application/views/EditRep.fxml"));
        		Scene scene = new Scene(root);
        		stage.setTitle("Recepcionista");
        		stage.setScene(scene);
        		stage.show();
        		stage.setOnCloseRequest(e ->{
        			tablaRecepcionista.setItems(db.getUsuaris());
        		}); 
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}else {
    		System.out.println("Selecciona un registre.");
    	}
    	
    }
    
    @FXML
    void eliminarRecepcionista(ActionEvent event) {
    	System.out.println("Eliminando...");
    }

    @FXML
    void buscarRecepcionista(KeyEvent event) {
    	tablaRecepcionista.setItems(db.getUsuaris(filtroRecepcionista.getText()));
    	
    }
    
    @FXML
	void initialize() {
    	id_column.setCellValueFactory(new PropertyValueFactory<Usuari, Integer>("id_usuari"));
    	nom_usuari_column.setCellValueFactory(new PropertyValueFactory<Usuari, String>("nom_usuari"));
    	nom_column.setCellValueFactory(new PropertyValueFactory<Usuari, String>("nom"));
    	cognom_column.setCellValueFactory(new PropertyValueFactory<Usuari, String>("cognom1"));
    	segon_cognom_column.setCellValueFactory(new PropertyValueFactory<Usuari, String>("cognom2"));
    	dni_column.setCellValueFactory(new PropertyValueFactory<Usuari, String>("DNI"));
    	passaport_column.setCellValueFactory(new PropertyValueFactory<Usuari, String>("passaport"));
    	nacionalitat_column.setCellValueFactory(new PropertyValueFactory<Usuari, String>("nacionalitat"));
    	telefon_column.setCellValueFactory(new PropertyValueFactory<Usuari, Integer>("telefon"));
    	email_column.setCellValueFactory(new PropertyValueFactory<Usuari, String>("email"));
    	activo_column.setCellValueFactory(new PropertyValueFactory<Usuari, Boolean>("activo"));
    	
    	tablaRecepcionista.setItems(db.getUsuaris());
    }
   
}


    
    
