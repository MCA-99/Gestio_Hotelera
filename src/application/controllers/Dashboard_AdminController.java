package application.controllers;

import com.jfoenix.controls.JFXButton;

import application.models.Database;
import application.models.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Dashboard_AdminController {
	private Database db = Database.getDatabase();
    @FXML
    private BorderPane subScene;

    @FXML
    private JFXButton recepcionistas_btn;

    @FXML
    private JFXButton habitacions_btn;

    @FXML
    private JFXButton productes_btn;

    @FXML
    private JFXButton gestio_pagaments_btn;

    @FXML
    private JFXButton consulta_informes_btn;

    @FXML
    private JFXButton logout_btn;

    @FXML
    void consulta_informes(ActionEvent event) {

    }

    @FXML
    void gestio_pagaments(ActionEvent event) {

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
    void logout(ActionEvent event) {
    	try {
    		db.clearUser();
    		Main.changeScene("/application/views/Login.fxml");
    	} catch(Exception e) {
			e.printStackTrace();
		}
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
    void recepcionistas(ActionEvent event) {
    	subScene.setCenter(null);
	    try {
	        AnchorPane root = (AnchorPane)FXMLLoader.load(Main.class.getResource("/application/views/GestioRecepcionista.fxml"));
	        subScene.setCenter(root);
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
    }

}

