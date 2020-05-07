package application.controllers;

import java.io.File;

import application.models.Main;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class MainController {
	
	@FXML MediaView bgVideo;
    String path = new File("src/bg/bg.mp4").getAbsolutePath();
	Media me = new Media(new File(path).toURI().toString());
	MediaPlayer md = new MediaPlayer(me);

    @FXML
    private BorderPane dynamicScene;

    @FXML
    void initialize() {
		Main.dynamicScene = dynamicScene;
		
		Main.changeScene("/application/views/Login.fxml");
		
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
}
