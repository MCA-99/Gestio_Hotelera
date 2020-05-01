package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Dashboard_AdminController {

    @FXML
    private Button gestio_habitacions;

    @FXML
    private Button gestio_productes;

    @FXML
    private Button gestio_pagaments;

    @FXML
    private Button consulta_informes;

    @FXML
    private Button logout;

    @FXML
    void consulta_informes(ActionEvent event) {

    }

    @FXML
    void gestio_habitacions(ActionEvent event) {

    }

    @FXML
    void gestio_pagaments(ActionEvent event) {

    }

    @FXML
    void gestio_productes(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {
    	try {
	    	Stage appStage;
	        Parent root;
	    	appStage=(Stage)logout.getScene().getWindow();
	        root=FXMLLoader.load(getClass().getResource("/application/views/Login.fxml"));
	        Scene scene=new Scene(root);
	        appStage.setScene(scene);
	        appStage.show();
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
