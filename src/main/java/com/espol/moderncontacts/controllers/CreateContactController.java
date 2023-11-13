
package com.espol.moderncontacts.controllers;

import com.espol.moderncontacts.AgregarContacto;
import static com.espol.moderncontacts.AgregarContacto.tipo;
import com.espol.moderncontacts.App;
import com.espol.moderncontacts.model.TipoDireccion;
import com.espol.moderncontacts.model.TipoEmail;
import com.espol.moderncontacts.model.TipoRedSocial;
import java.io.IOException;
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
import javafx.scene.input.MouseEvent;
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
                App.setRoot("agregarContacto");
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
                App.setRoot("agregarContacto");
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
