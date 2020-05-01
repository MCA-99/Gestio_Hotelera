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

public class Dashboard_AdminController {
	private Database db = Database.getDatabase();
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
    		db.clearUser();
    		Main.changeScene("/application/views/Login.fxml");
    	} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
