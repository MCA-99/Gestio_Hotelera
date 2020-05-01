package application.controllers;

import java.awt.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Dashboard_RecepcionistaController {

    @FXML
    private Button gestio_clients;

    @FXML
    private Button serveis_extra;

    @FXML
    private Button reserva_habitacions;

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
    void gestio_clients(ActionEvent event) {

    }

    @FXML
    void gestio_pagaments(ActionEvent event) {

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

    @FXML
    void reserva_habitacions(ActionEvent event) {

    }

    @FXML
    void serveis_extra(ActionEvent event) {

    }

}
