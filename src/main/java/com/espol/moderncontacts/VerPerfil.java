
package com.espol.moderncontacts;

import com.espol.moderncontacts.model.Contacto;
import com.espol.moderncontacts.model.Empresa;
import com.espol.moderncontacts.model.Persona;
import com.espol.moderncontacts.util.ModelUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
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
    private Label direcciones;

    @FXML
    private Label fechas;

    @FXML
    private Label redes;
    
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
        Contacto contacto = objeto.get(9); //Eliminar cuando se enlazen las páginas
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
    void borrarPerfil(MouseEvent event) {
        
    }

    @FXML
    void retroceder(MouseEvent event) {

    }
    
    private void llenarPersona(Persona p){
        nombrePerfil.setText(p.getNombreCompleto());
        numeros.setText(p.getTelefono());
        if (p.getFotoPerfil()!=null){fotoPerfil.setImage(ModelUtils.getImage(App.fotoRuta + p.getFotoPerfil()));}
        if (p.getDireccion()!=null){direcciones.setText(p.getDireccion().toString());}
        if (!p.getEmails().isEmpty()){emails.setText(p.getTodoEmail());}
        if (p.getFechaCumple()!=null){fechas.setText(p.getFechaCumple().toString());}
        if (!p.getRedesSociales().isEmpty()){redes.setText(p.getTodoRedes());}
    }
    
    private void llenarEmpresa(Empresa e){
        nombrePerfil.setText(e.getNombreCompleto());
        numeros.setText(e.getTelefono());
        if (e.getFotoPerfil()!=null){fotoPerfil.setImage(ModelUtils.getImage(App.fotoRuta + e.getFotoPerfil()));}
        if (e.getDireccion()!=null){direcciones.setText(e.getDireccion().toString());}
        if (!e.getEmails().isEmpty()){emails.setText(e.getTodoEmail());}
        if (e.getFechaAniversario()!=null){fechas.setText(e.getFechaAniversario().toString());}
        if (!e.getRedesSociales().isEmpty()){redes.setText(e.getTodoRedes());}
    }

}

