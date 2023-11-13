
package com.espol.moderncontacts.controllers;

import static com.espol.moderncontacts.controllers.AgregarContacto.tipo;
import com.espol.moderncontacts.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author ariel
 */
public class CreateContact implements Initializable {


    @FXML
    private VBox vbox;
    @FXML
    private Button btnEm;
    @FXML
    private Button btnPer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    

    @FXML
    private void crearContactEmp(MouseEvent event) {
        AgregarContacto.tipo = "empresa";
        if (tipo.equals("empresa")){
            try {
                App.setRoot("addContact");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void crearContactPerson(MouseEvent event) {
        AgregarContacto.tipo = "persona";
        if (tipo.equals("persona")){
            try {
                App.setRoot("addContact");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    private void retroceder(MouseEvent event) {
        try {
            App.setRoot("primary");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
