package application.controllers;

import java.io.File;

import application.models.Database;
import javafx.scene.media.MediaView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class LoginController {
	
	private Database db = Database.getDatabase();
	@FXML MediaView bgVideo;
    String path = new File("src/bg/bg.mp4").getAbsolutePath();
	Media me = new Media(new File(path).toURI().toString());
	MediaPlayer md = new MediaPlayer(me);
	@FXML
    private Button accedir;

    @FXML
    private Button registrarse;

    @FXML
    private TextField usuari;

    @FXML
    private PasswordField contrasenya;
    @FXML // This method is called by the FXMLLoader when initialization is complete
    
    void initialize() {
    	// Set video as the login background
    	// Look for good short videos
    	
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
    	
    	
    	// signinForm.setTranslateY(500);
        // signupForm.setTranslateY(500);
        // recoverForm.setTranslateY(500);
                
        // translateAnimationForm(signinForm, Duration.millis(500), Duration.millis(500));
    }
    
    
    @FXML
    void login(ActionEvent event) {
    	String usuari = usuari.getText();
    	String contrasenya = contrasenya.getText();
    	
    	if(db.comprovarUsuari() == true) {
    		System.out.println("Usuari logejat amb exit.");
    	}
    }
}
