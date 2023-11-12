
package com.espol.moderncontacts;

import com.espol.moderncontacts.model.Contacto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class VerPerfil {

    @FXML
    private ImageView fotoPerfil;

    @FXML
    private Label nombrePerfil;

    @FXML
    private Label numeros;

    @FXML
    private Label emails;

    @FXML
    private Label driecciones;

    @FXML
    private Label fechas;

    @FXML
    private Label redes;
    
    @FXML
    void initialize(){
        Contacto contacto = Contacto.getSelectedContact();
        
    }

    @FXML
    void borrarPerfil(MouseEvent event) {

    }

    @FXML
    void retroceder(MouseEvent event) {

    }

}

