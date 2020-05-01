package application.controllers;

import application.models.Main;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class MainController {
	@FXML
	private BorderPane dynamicScene;
	
	@FXML
    void initialize() {
		Main.dynamicScene = dynamicScene;
		
		Main.changeScene("/application/views/Login.fxml");
    }
}