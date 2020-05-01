package application.controllers;

import java.io.File;

import application.models.Database;
import javafx.scene.media.MediaView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
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
    void register_button(ActionEvent event) {
    	System.out.println("nombre de usuario: " + nom_usuari.getText());
    }
}

