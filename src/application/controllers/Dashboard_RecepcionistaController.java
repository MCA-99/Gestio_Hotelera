package application.controllers;

import application.models.Database;
import application.models.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Dashboard_RecepcionistaController {


	private Database db = Database.getDatabase();
	
	@FXML
    private Button gestio_clients_btn;

    @FXML
    private Button serveis_extra_btn;

    @FXML
    private Button reserva_habitacions_btn;

    @FXML
    private Button gestio_pagaments_btn;

    @FXML
    private Button consulta_informes_btn;

    @FXML
    private Button logout_btn;

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
