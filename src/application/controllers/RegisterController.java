package application.controllers;

import java.io.File;

import application.models.Database;
import application.models.Main;
import application.models.Usuari;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
	
	private Database db = Database.getDatabase();
	
	@FXML MediaView bgVideo;
    String path = new File("src/bg/bg.mp4").getAbsolutePath();
	Media me = new Media(new File(path).toURI().toString());
	MediaPlayer md = new MediaPlayer(me);

    @FXML
    private TextField nom_usuari;

    @FXML
    private PasswordField contrasenya;
    
    @FXML
    private TextField nom;

    @FXML
    private TextField cognom1;

    @FXML
    private TextField cognom2;

    @FXML
    private TextField dni;

    @FXML
    private TextField passaport;

    @FXML
    private TextField nacionalitat;

    @FXML
    private TextField telefon;

    @FXML
    private TextField email;
    
    @FXML
    private Label error;
    
    @FXML
    private Label success;
    
    @FXML
    private Button logout;

    @FXML
    void register(ActionEvent event) {

    }
    
    @FXML
    void initialize() {
    	md.setOnEndOfMedia(new Runnable() {
			@Override
			public void run() {
				md.seek(Duration.ZERO);
				md.play();
			}
		});
    	
    	bgVideo.setMediaPlayer(md);
    	md.setAutoPlay(true);
    	md.setVolume(0);
    }
    
    @FXML
    void logout(ActionEvent event) {
    	try {
    		Main.changeScene("/application/views/Login.fxml");
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void register_button_recepcionista(ActionEvent event) {
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
    
}

