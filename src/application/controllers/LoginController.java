package application.controllers;

import java.io.File;
import java.io.IOException;

import application.models.Database;
import application.models.Usuari;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class LoginController {
	
	private Database db = Database.getDatabase();
	private Usuari userLoged = db.getUserLoged();
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
    void login(ActionEvent event) {
    	String user = usuari.getText();
    	String pass = contrasenya.getText();
    	
    	if(db.logear(user, pass) == true) {
    		System.out.println("Usuari logejat amb exit.");
    		System.out.println("nom usuari: "+userLoged.getNom_usuari() + " contrasenya: " + userLoged.getContrasenya());
    	}
    	else {
    		System.out.println("Usuari i/o contrasenya incorrecta.");
    	}
    }
    
    @FXML
    void goToRegister(ActionEvent event) throws IOException {
    	try {
	    	Stage appStage;
	        Parent root;
	    	appStage=(Stage)registrarse.getScene().getWindow();
	        root=FXMLLoader.load(getClass().getResource("/application/views/Register.fxml"));
	        Scene scene=new Scene(root);
	        appStage.setScene(scene);
	        appStage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    
}
