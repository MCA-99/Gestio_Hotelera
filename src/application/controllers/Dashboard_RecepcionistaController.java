package application.controllers;

import com.jfoenix.controls.JFXButton;

import application.models.Database;
import application.models.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class Dashboard_RecepcionistaController {
	private Database db = Database.getDatabase();
    @FXML
    private BorderPane subScene;

    @FXML
    private JFXButton gestio_clients_btn;

    @FXML
    private JFXButton serveis_extra_btn;

    @FXML
    private JFXButton reserva_habitacions_btn;

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
    void gestio_clients(ActionEvent event) {

    }

    @FXML
    void gestio_pagaments(ActionEvent event) {

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
    void reserva_habitacions(ActionEvent event) {

    }

    @FXML
    void serveis_extra(ActionEvent event) {

    }

}

