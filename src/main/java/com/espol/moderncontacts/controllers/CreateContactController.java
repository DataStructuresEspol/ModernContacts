/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.espol.moderncontacts.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author ariel
 */
public class CreateContactController implements Initializable {


    @FXML
    private VBox vbox;
    @FXML
    private RadioButton rbEmp;
    @FXML
    private RadioButton rbPer;
    @FXML
    private HBox hbox;
    @FXML
    private ToggleGroup Usuarios;
    @FXML
    private VBox vboxnuevo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void acEmp(ActionEvent event) {
        if(rbEmp.isSelected()){
            vboxnuevo.getChildren().clear();
            HBox hbox = new HBox();
            HBox hbox2 = new HBox();
            
            Label l1 = new Label("Nombre Empresa: ");
            TextField text1 = new TextField();
            text1.setPromptText("nombre");
            
            Label l2 = new Label("Direccion: ");
            TextField text2 = new TextField();
            text2.setPromptText("direccion");
            
            hbox.getChildren().addAll(l1, text1);
            hbox2.getChildren().addAll(l2, text2);
            
            vboxnuevo.getChildren().addAll(hbox, hbox2);
        }
    }

    @FXML
    private void acPer(ActionEvent event) {
        if(rbPer.isSelected()){
            vboxnuevo.getChildren().clear();
            HBox hbox = new HBox();
            HBox hbox2 = new HBox();
            HBox hbox3 = new HBox();
            
            Label l1 = new Label("Nombre: ");
            TextField text1 = new TextField();
            text1.setPromptText("nombre");
            
            Label l2 = new Label("Apellido: ");
            TextField text2 = new TextField();
            text2.setPromptText("apellido");
            
            Label l3 = new Label("Teléfono: ");
            TextField text3 = new TextField();
            text3.setPromptText("numero");
            
            hbox.getChildren().addAll(l1, text1);
            hbox2.getChildren().addAll(l2, text2);
            hbox3.getChildren().addAll(l3, text3);
            
            vboxnuevo.getChildren().addAll(hbox, hbox2, hbox3);
        }
    }
    
    
    
}
