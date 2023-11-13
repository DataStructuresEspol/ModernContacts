
package com.espol.moderncontacts.controllers;

import com.espol.moderncontacts.App;
import com.espol.moderncontacts.model.Direccion;
import com.espol.moderncontacts.model.Email;
import com.espol.moderncontacts.model.Empresa;
import com.espol.moderncontacts.model.Persona;
import com.espol.moderncontacts.model.RedSocial;
import com.espol.moderncontacts.model.TipoDireccion;
import com.espol.moderncontacts.model.TipoEmail;
import com.espol.moderncontacts.model.TipoRedSocial;

import java.io.IOException;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

public class AgregarContacto {

    @FXML
    private Circle profilePic;

    @FXML
    private TextField celular;
    @FXML
    public ChoiceBox<TipoEmail> tipoEmail;
    @FXML
    private TextField email;
    @FXML
    public ChoiceBox<TipoDireccion> tipoDireccion;
    @FXML
    private TextField direccion;
    @FXML
    private TextField fecha;
    @FXML
    public ChoiceBox<TipoRedSocial> tipoRed;
    @FXML
    private TextField red;
    
    public static String tipo;
    @FXML
    private TextField nombre;

    @FXML
    private TextField apellido;
    @FXML
    public HBox nombreBox;

    @FXML
    void initialize(){
        if (tipo.equals("empresa")){
            nombreBox.getChildren().remove(2);
            nombreBox.getChildren().remove(2);
        }
        tipoEmail.getItems().addAll(TipoEmail.values());
        tipoDireccion.getItems().addAll(TipoDireccion.values());
        tipoRed.getItems().addAll(TipoRedSocial.values());
    }
    
    @FXML
    private void retroceder(MouseEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void guardarPerfil(MouseEvent event) {
        if (tipo.equals("persona")){
            Persona persona = new Persona(nombre.getText(), apellido.getText(), celular.getText());
            persona.getEmails().add(new Email(email.getText(), tipoEmail.getValue()));
            persona.setDireccion(new Direccion(direccion.getText(), tipoDireccion.getValue()));
            persona.setFechaCumple(new Date(fecha.getText()));
            persona.getRedesSociales().add(new RedSocial(red.getText(), tipoRed.getValue()));
        }
        else{
            Empresa empresa = new Empresa(nombre.getText(), celular.getText());
            empresa.getEmails().add(new Email(email.getText(), tipoEmail.getValue()));
            empresa.setDireccion(new Direccion(direccion.getText(), tipoDireccion.getValue()));
            empresa.setFechaAniversario(new Date(fecha.getText()));
            empresa.getRedesSociales().add(new RedSocial(red.getText(), tipoRed.getValue()));
        }

    }

   
}