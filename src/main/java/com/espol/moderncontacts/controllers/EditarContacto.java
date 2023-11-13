
package com.espol.moderncontacts.controllers;

import com.espol.moderncontacts.App;
import com.espol.moderncontacts.PrimaryController;
import com.espol.moderncontacts.model.Contacto;
import com.espol.moderncontacts.model.Direccion;
import com.espol.moderncontacts.model.Email;
import com.espol.moderncontacts.model.Empresa;
import com.espol.moderncontacts.model.Persona;
import com.espol.moderncontacts.model.RedSocial;
import com.espol.moderncontacts.model.TipoDireccion;
import com.espol.moderncontacts.model.TipoEmail;
import com.espol.moderncontacts.model.TipoRedSocial;
import com.espol.moderncontacts.util.LoadImage;
import com.espol.moderncontacts.util.ModelUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

public class EditarContacto {

    @FXML
    private Circle profilePic;
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
    private ChoiceBox<TipoRedSocial> tipoRed;
    @FXML
    private TextField red;
    
    private Contacto contacto;
    @FXML
    private TextField anio;
    @FXML
    private TextField mes;
    @FXML
    private TextField dia;
    @FXML
    void initialize(){
        
        contacto = Contacto.getSelectedContact();
       
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
    private void retroceder(MouseEvent event) throws IOException{
        App.setRoot("verPerfil");
    }

    @FXML
    private void guardarPerfil(MouseEvent event) throws IOException{
        if (contacto.getTipo().equals("persona")){
            Persona persona = (Persona) Contacto.getSelectedContact();
            persona.setNombre(nombre.getText());
            persona.setApellido(apellido.getText());
            persona.setTelefono(celular.getText());
            boolean find = false;
            if(tipoEmail.getValue()!=null && !email.getText().isBlank()){
                for (int i=0; i<persona.getEmails().size(); i++){
                    if (persona.getEmails().get(i).getTipoEmail().equals(tipoEmail.getValue())){
                        persona.getEmails().get(i).setEmail(email.getText());
                        persona.getEmails().get(i).setTipoEmail(tipoEmail.getValue());
                        find = true;
                    }
                }
             if (!find){persona.getEmails().add(new Email(email.getText(), tipoEmail.getValue()));}
            }
            if(!direccion.getText().isBlank()){
                persona.setDireccion(new Direccion(direccion.getText(), tipoDireccion.getValue()));
            }
            
            if(!anio.getText().isBlank() && !mes.getText().isBlank() && !dia.getText().isBlank()){
                persona.setFechaCumple(new Date(Integer.parseInt(
                        anio.getText()), Integer.parseInt(mes.getText()), Integer.parseInt(dia.getText())));
            }
            find = false;
            if(!red.getText().isBlank() && tipoRed.getValue()!=null){
                
                if(tipoEmail.getValue()!=null && !email.getText().isBlank()){
                for (int i=0; i<persona.getRedesSociales().size(); i++){
                    if (persona.getRedesSociales().get(i).getTipoRedSocial().equals(tipoRed.getValue())){
                        persona.getRedesSociales().get(i).setRed(red.getText());
                        persona.getRedesSociales().get(i).setTipoRedSocial(tipoRed.getValue());
                        find = true;
                    }
                }
             if (!find){persona.getRedesSociales().add(new RedSocial(red.getText(), tipoRed.getValue()));}
            }
            }
        }
        else{
            Empresa empresa = (Empresa) Contacto.getSelectedContact();
            empresa.setNombre(nombre.getText());
            empresa.setTelefono(celular.getText());
            boolean find = false;
            if(tipoEmail.getValue()!=null && !email.getText().isBlank()){
                for (int i=0; i<empresa.getEmails().size(); i++){
                    if (empresa.getEmails().get(i).getTipoEmail().equals(tipoEmail.getValue())){
                        empresa.getEmails().get(i).setEmail(email.getText());
                        empresa.getEmails().get(i).setTipoEmail(tipoEmail.getValue());
                        find = true;
                    }
                }
             if (!find){empresa.getEmails().add(new Email(email.getText(), tipoEmail.getValue()));}
            }
            if(!direccion.getText().isBlank()){
                empresa.setDireccion(new Direccion(direccion.getText(), tipoDireccion.getValue()));
            }
            
            if(!anio.getText().isBlank() && !mes.getText().isBlank() && !dia.getText().isBlank()){
                empresa.setFechaAniversario(new Date(Integer.parseInt(
                        anio.getText()), Integer.parseInt(mes.getText()), Integer.parseInt(dia.getText())));
            }
            find = false;
            if(!red.getText().isBlank() && tipoRed.getValue()!=null){
                
                if(tipoEmail.getValue()!=null && !email.getText().isBlank()){
                for (int i=0; i<empresa.getRedesSociales().size(); i++){
                    if (empresa.getRedesSociales().get(i).getTipoRedSocial().equals(tipoRed.getValue())){
                        empresa.getRedesSociales().get(i).setRed(red.getText());
                        empresa.getRedesSociales().get(i).setTipoRedSocial(tipoRed.getValue());
                        find = true;
                    }
                }
             if (!find){empresa.getRedesSociales().add(new RedSocial(red.getText(), tipoRed.getValue()));}
            }
            }
        }
        App.setRoot("verPerfil");
    }
    
    private void llenarPersona(Persona p){
        profilePic.setFill(LoadImage.loadPattern(PrimaryController.RESOURCES_PATH + "fotos/" + p.getFotoPerfil()));
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
        if (p.getFechaCumple()!=null){
            anio.setText(p.getFechaCumple().getYear()+"");
            mes.setText(p.getFechaCumple().getMonth()+"");
            dia.setText(p.getFechaCumple().getDay()+"");
        }
        if (!p.getRedesSociales().isEmpty()){
            tipoRed.setValue(p.getRedesSociales().get(0).getTipoRedSocial());
            red.setText(p.getRedesSociales().get(0).getRed());
        }
        
    }
    
    private void llenarEmpresa(Empresa e){
        profilePic.setFill(LoadImage.loadPattern(PrimaryController.RESOURCES_PATH + "fotos/" + e.getFotoPerfil()));
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
        if (e.getFechaAniversario()!=null){
            anio.setText(e.getFechaAniversario().getYear()+"");
            mes.setText(e.getFechaAniversario().getMonth()+"");
            dia.setText(e.getFechaAniversario().getDay()+"");}
        if (!e.getRedesSociales().isEmpty()){
            tipoRed.setValue(e.getRedesSociales().get(0).getTipoRedSocial());
            red.setText(e.getRedesSociales().get(0).getRed());
        }
    }
    
}
