
package com.espol.moderncontacts.controllers;

import com.espol.moderncontacts.PrimaryController;
import com.espol.moderncontacts.model.Contacto;
import com.espol.moderncontacts.model.Persona;
import com.espol.moderncontacts.util.LoadImage;
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
        String ruta = "src/main/resources/com/espol/moderncontacts/serializables/contactos.ser";
        ArrayList<Contacto> objeto = new ArrayList<Contacto>();
        try {
            FileInputStream fileIn = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            objeto = (ArrayList<Contacto>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Contacto contacto = objeto.get(1);
        if (contacto.getTipo().equals("persona")){
            Persona persona = (Persona) contacto;
            System.out.println(persona.getFotoPerfil());
            llenarPersona(persona);
        }
    }

    @FXML
    void borrarPerfil(MouseEvent event) {}

    @FXML
    void retroceder(MouseEvent event) {}
    
    private void llenarPersona(Persona p){
        nombrePerfil.setText(p.getNombreCompleto());
        numeros.setText(p.getTelefono());
        profilePic.setFill(LoadImage.loadPattern(PrimaryController.RESOURCES_PATH + "fotos/" + p.getFotoPerfil()));
        if (p.getDireccion()!=null){direcciones.setText(p.getDireccion().toString());}
        if (!p.getEmails().isEmpty()){emails.setText(p.getTodoEmail());}
        if (p.getFechaCumple()!=null){fechas.setText(p.getFechaCumple().toString());}
        if (!p.getRedesSociales().isEmpty()){redes.setText(p.getTodoRedes());}
    }
}

