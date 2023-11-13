
package com.espol.moderncontacts.controllers;

import com.espol.moderncontacts.App;
import com.espol.moderncontacts.PrimaryController;
import com.espol.moderncontacts.model.Contacto;
import com.espol.moderncontacts.model.Empresa;
import com.espol.moderncontacts.model.Persona;
import com.espol.moderncontacts.util.LoadImage;
import com.espol.moderncontacts.util.ModelUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class VerPerfil {
    @FXML
    private Label nombrePerfil;

    @FXML
    private Label numeros;

    @FXML
    private Label emails;

    @FXML
    private Label direcciones;

    @FXML
    private Label fechas;

    @FXML
    private Label redes;

    @FXML
    private Circle profilePic;
    @FXML
    void initialize(){
        Contacto contacto = Contacto.getSelectedContact(); 
        if (contacto.getTipo().equals("persona")){
            Persona persona = (Persona) contacto;
            llenarPersona(persona);
        }
        else{
            Empresa empresa = (Empresa) contacto;
            llenarEmpresa(empresa);
        }

    }

    @FXML
    void borrarPerfil(MouseEvent event) throws IOException{
        Contacto.getUser().getContactosRelacionados().remove(Contacto.getSelectedContact());
        App.setRoot("primary");
    }

    @FXML
    void retroceder(MouseEvent event) throws IOException{
        App.setRoot("primary");
    }
    
    private void llenarPersona(Persona p){
        nombrePerfil.setText(p.getNombreCompleto());
        numeros.setText(p.getTelefono());
        profilePic.setFill(LoadImage.loadPattern(PrimaryController.RESOURCES_PATH + "fotos/" + p.getFotoPerfil()));
        if (p.getDireccion()!=null){direcciones.setText(p.getDireccion().toString());}
        if (!p.getEmails().isEmpty()){emails.setText(p.getTodoEmail());}
        if (p.getFechaCumple()!=null){fechas.setText(p.getFechaString());}
        if (!p.getRedesSociales().isEmpty()){redes.setText(p.getTodoRedes());}
    }
    
    private void llenarEmpresa(Empresa e){
        nombrePerfil.setText(e.getNombreCompleto());
        numeros.setText(e.getTelefono());
        profilePic.setFill(LoadImage.loadPattern(PrimaryController.RESOURCES_PATH + "fotos/" + e.getFotoPerfil()));
        if (e.getDireccion()!=null){direcciones.setText(e.getDireccion().toString());}
        if (!e.getEmails().isEmpty()){emails.setText(e.getTodoEmail());}
        if (e.getFechaAniversario()!=null){
            fechas.setText(e.getFechaString());
        }
        if (!e.getRedesSociales().isEmpty()){redes.setText(e.getTodoRedes());}
    }

    @FXML
    private void editarPerfil(MouseEvent event) throws IOException{
        App.setRoot("editContact");
    }

}

