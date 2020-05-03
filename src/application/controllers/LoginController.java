package application.controllers;

import java.io.File;
import java.io.IOException;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;
import application.models.Database;
import application.models.Main;
import application.models.Usuari;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class LoginController {
	
	private Database db = Database.getDatabase();
	private Usuari userLoged = db.getUserLoged();
	
	public static Stage register;
	
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
    private Label loginError;
    
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
    
    
    void _login() {
    	String user = usuari.getText();
    	String pass = db.getMD5(contrasenya.getText());
    	
    	if(db.logear(user, pass)) {
    		userLoged = db.getUserLoged();
    		System.out.println(userLoged.getActivo());
    		if(userLoged.getActivo() != false) {
    			switch(userLoged.getRol()) {
		    		case "admin":
		    			System.out.println("Usuari logejat amb exit.");
		        		System.out.println("nom usuari: "+userLoged.getNom_usuari() + " contrasenya: " + userLoged.getContrasenya());
		        		Main.changeScene("/application/views/Dashboard_Admin.fxml");
		    			break;
		    		case "rep":
		    			System.out.println("Usuari logejat amb exit.");
		        		System.out.println("nom usuari: "+userLoged.getNom_usuari() + " contrasenya: " + userLoged.getContrasenya());
		        		Main.changeScene("/application/views/Dashboard_Recepcionista.fxml");
		    			break;
		    		default:
		    			break;
    			}
    		}
    		else {
    			userLoged = null;
    			loginError.setText("");
    			loginError.setText("El usuari es troba desactivat.");
    		}
    	}
    	else {
    		loginError.setText("");
			loginError.setText("Inici de sesió incorrecte.");
		}
    		
    }
    
    @FXML
    void login(ActionEvent event) {
    	_login();
    }
    
    @FXML
    void loginOnEnter(KeyEvent event) {
    	if(event.getCode().compareTo(KeyCode.ENTER) == 0) {
    		_login();
    	}
    }
   
    @FXML
    void goToRegister(ActionEvent event) throws IOException {
    	try {
    		Main.changeScene("/application/views/Register.fxml");
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    
}
