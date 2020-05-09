package application.controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import application.models.Database;
import application.models.Usuari;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class EditRepController {
	
	private Usuari userEdit;
	private Database db = Database.getDatabase();
	
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
    private JFXCheckBox actiu;

    @FXML
    private JFXButton guardar_btn;
    
    @FXML
    void guardar(ActionEvent event) {
    	db.updateUsuari(userEdit.getId_usuari(), nom_usuari.getText(), nom.getText(), cognom.getText(), segon_cognom.getText(), dni.getText(), passaport.getText(), nacionalitat.getText(), telefon.getText(), email.getText(), actiu.isSelected());
    	Stage stage = (Stage) guardar_btn.getScene().getWindow();
    	stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
    }
    
    @FXML
    void initialize() {
    	nom_usuari.setText(userEdit.getNom_usuari());
    	nom.setText(userEdit.getNom());
    	cognom.setText(userEdit.getCognom1());
    	segon_cognom.setText(userEdit.getCognom2());
    	dni.setText(userEdit.getDNI());
    	passaport.setText(userEdit.getPassaport());
    	nacionalitat.setText(userEdit.getNacionalitat());
    	telefon.setText(userEdit.getTelefon());
    	email.setText(userEdit.getEmail());
    	actiu.setSelected(userEdit.getActivo());
    }

}

