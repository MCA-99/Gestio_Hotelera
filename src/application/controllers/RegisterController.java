package application.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import application.models.Database;
import application.models.Main;
import application.models.Usuari;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RegisterController {

	private Database db = Database.getDatabase();
    @FXML
    private JFXTextField nom_usuari;

    @FXML
    private JFXTextField contrasenya;

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField cognom1;

    @FXML
    private JFXTextField cognom2;

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
    private JFXButton tornar_btn;

    @FXML
    private JFXButton registrarse_btn;
    
    @FXML
    private Label error;

    @FXML
    private Label success;

    @FXML
    void registrarse(ActionEvent event) {
    	Usuari user = new Usuari();
    	if(!nom_usuari.getText().isEmpty() && !contrasenya.getText().isEmpty() && !nom.getText().isEmpty() && !cognom1.getText().isEmpty() && !cognom2.getText().isEmpty() && !dni.getText().isEmpty() && !passaport.getText().isEmpty() && !nacionalitat.getText().isEmpty() && !telefon.getText().isEmpty() && !email.getText().isEmpty()) {
    		if(db.comprovarExistencia(nom_usuari.getText(), "nom_usuari", "Usuaris") == false && db.comprovarExistencia(email.getText(), "email", "Usuaris") == false ) {
    			user.insert(nom_usuari.getText(), db.getMD5(contrasenya.getText()), nom.getText(), cognom1.getText(), cognom2.getText(), dni.getText(), passaport.getText(), nacionalitat.getText(), telefon.getText(), email.getText());
    			error.setText("");
    			success.setText("Usuari Registrat");
    		}
    		else {
    			error.setText("");
    			error.setText("Nom usuari i/o contrasenya existents.");
    		}
    	}
    	else {
    		success.setText("");
    		error.setText("Omple tots els camps.");
    	}
    }

    @FXML
    void tornar(ActionEvent event) {
    	try {
    		Main.changeScene("/application/views/Login.fxml");
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }

}


