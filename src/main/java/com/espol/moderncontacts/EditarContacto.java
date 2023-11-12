
package com.espol.moderncontacts;

import com.espol.moderncontacts.model.Contacto;
import com.espol.moderncontacts.model.Direccion;
import com.espol.moderncontacts.model.Email;
import com.espol.moderncontacts.model.Empresa;
import com.espol.moderncontacts.model.Persona;
import com.espol.moderncontacts.model.RedSocial;
import com.espol.moderncontacts.model.TipoDireccion;
import com.espol.moderncontacts.model.TipoEmail;
import com.espol.moderncontacts.model.TipoRedSocial;
import com.espol.moderncontacts.util.ModelUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class EditarContacto {

    @FXML
    private ImageView fotoPerfil;
    @FXML
    private HBox nombreBox;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private TextField celular;
    @FXML
    private ChoiceBox<TipoEmail> tipoEmail;
    @FXML
    private TextField email;
    @FXML
    private ChoiceBox<TipoDireccion> tipoDireccion;
    @FXML
    private TextField direccion;
    @FXML
    private TextField fecha;
    @FXML
    private ChoiceBox<TipoRedSocial> tipoRed;
    @FXML
    private TextField red;
    
    private Contacto contacto;
    
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
        contacto = objeto.get(9); //Eliminar cuando se enlazen las páginas
       
        if (contacto.getTipo().equals("empresa")){
            nombreBox.getChildren().remove(2);
            nombreBox.getChildren().remove(2);
            Empresa empresa = (Empresa) contacto;
            llenarEmpresa(empresa);
        }
        else{
            Persona persona = (Persona) contacto;
            llenarPersona(persona);
        }
        tipoEmail.getItems().addAll(TipoEmail.values());
        tipoDireccion.getItems().addAll(TipoDireccion.values());
        tipoRed.getItems().addAll(TipoRedSocial.values());
        
    }
    
    @FXML
    private void retroceder(MouseEvent event) {
    }

    @FXML
    private void guardarPerfil(MouseEvent event) {
        if (contacto.getTipo().equals("persona")){
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
    
    private void llenarPersona(Persona p){
        if (p.getFotoPerfil()!=null){fotoPerfil.setImage(ModelUtils.getImage(App.fotoRuta + p.getFotoPerfil()));}
        nombre.setText(p.getNombre());
        apellido.setText(p.getApellido());
        celular.setText(p.getTelefono());
        if (!p.getEmails().isEmpty()){
            tipoEmail.setValue(p.getEmails().get(0).getTipoEmail());
            email.setText(p.getEmails().get(0).getEmail());
        }
        if (p.getDireccion()!=null){
            tipoDireccion.setValue(p.getDireccion().getTipoDireccion());
            direccion.setText(p.getDireccion().getDireccion());
        }
        if (p.getFechaCumple()!=null){fecha.setText(p.getFechaCumple().toString());}
        if (!p.getRedesSociales().isEmpty()){
            tipoRed.setValue(p.getRedesSociales().get(0).getTipoRedSocial());
            red.setText(p.getRedesSociales().get(0).getRed());
        }
        
    }
    
    private void llenarEmpresa(Empresa e){
        if (e.getFotoPerfil()!=null){fotoPerfil.setImage(ModelUtils.getImage(App.fotoRuta + e.getFotoPerfil()));}
        nombre.setText(e.getNombre());
        celular.setText(e.getTelefono());
        if (!e.getEmails().isEmpty()){
            tipoEmail.setValue(e.getEmails().get(0).getTipoEmail());
            email.setText(e.getEmails().get(0).getEmail());
        }
        if (e.getDireccion()!=null){
            tipoDireccion.setValue(e.getDireccion().getTipoDireccion());
            direccion.setText(e.getDireccion().getDireccion());
        }
        if (e.getFechaAniversario()!=null){fecha.setText(e.getFechaAniversario().toString());}
        if (!e.getRedesSociales().isEmpty()){
            tipoRed.setValue(e.getRedesSociales().get(0).getTipoRedSocial());
            red.setText(e.getRedesSociales().get(0).getRed());
        }
    }
    
}
