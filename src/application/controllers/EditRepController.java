package application.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class EditRepController {

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField cognom;

    @FXML
    private JFXTextField nom_usuari;

    @FXML
    private JFXTextField segon_cognom;

    @FXML
    private JFXTextField dni;

    @FXML
    private JFXTextField passaport;

    @FXML
    private JFXTextField nacionalitat;

    @FXML
    private JFXTextField telefon;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXButton guardar_btn;

    public EditRepController() {
    	
    }
    
    @FXML
    void guardar(ActionEvent event) {

    }

}

