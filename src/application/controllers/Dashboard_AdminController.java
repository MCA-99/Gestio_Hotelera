package application.controllers;

import application.models.Database;
import application.models.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Dashboard_AdminController {
	private Database db = Database.getDatabase();
	@FXML
    private Button habitacions_btn;

    @FXML
    private Button productes_btn;

    @FXML
    private Button gestio_pagaments_btn;

    @FXML
    private Button consulta_informes_btn;

    @FXML
    private Button logout;

    @FXML
    private Button recepcionista_btn;
    
    @FXML
    private BorderPane subScene;

    @FXML
    void consulta_informes(ActionEvent event) {

    }

    @FXML
    void habitacions(ActionEvent event) {
    	subScene.setCenter(null);
	    try {
	        AnchorPane root = (AnchorPane)FXMLLoader.load(Main.class.getResource("/application/views/GestioHabitacio.fxml"));
	        subScene.setCenter(root);
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
    }

    @FXML
    void gestio_pagaments(ActionEvent event) {

    }

    @FXML
    void productes(ActionEvent event) {
    	subScene.setCenter(null);
	    try {
	        AnchorPane root = (AnchorPane)FXMLLoader.load(Main.class.getResource("/application/views/GestioProductes.fxml"));
	        subScene.setCenter(root);
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
    }
    

    @FXML
    void recepcionista(ActionEvent event) {
    	subScene.setCenter(null);
	    try {
	        AnchorPane root = (AnchorPane)FXMLLoader.load(Main.class.getResource("/application/views/GestioRecepcionista.fxml"));
	        subScene.setCenter(root);
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
    }
    
    

    @FXML
    void logout(ActionEvent event) {
    	try {
    		db.clearUser();
    		Main.changeScene("/application/views/Login.fxml");
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
