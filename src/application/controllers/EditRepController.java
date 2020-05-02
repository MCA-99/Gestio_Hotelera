package application.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import application.models.Usuari;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditRepController {
	
	private Usuari userEdit;

	public EditRepController() {
		this.userEdit = GestioRecepcionistaController.userEdit;
    }
   
	@FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField cognom;

    @FXML
    private JFXTextField nom_usuari;

    @FXML
    private JFXTextField segon_cognom;

    @FXML
    private JFXTextField dni;

    @FXML
    private JFXTextField passaport;

    @FXML
    private JFXTextField nacionalitat;

    @FXML
    private JFXTextField telefon;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXButton guardar_btn;
    
    @FXML
    void guardar(ActionEvent event) {
    	nom.setText(userEdit.getNom());
    }
    
    @FXML
    void initialize() {
    	nom.setText(userEdit.getNom());
    }

}

