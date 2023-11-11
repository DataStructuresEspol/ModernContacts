
package com.espol.moderncontacts.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Contacto implements Serializable{
    private String nombre;
    private int id;
    private String telefono;
    private String codePais;
    private String fotoPerfil;
    private List<String> fotos;
    private Direccion direccion;
    private List<Email> emails;
    private List<RedSocial> redesSociales;
    private LinkedList<Contacto> contactosRelacionados;
    private LinkedList<Integer> amigos;
    private LinkedList<Integer> familiares;
    private LinkedList<Integer> companeros;
    private LinkedList<Integer> favoritos;

    public Contacto(String nombre, String telefono, String codePais) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.codePais = codePais;
        fotos = new ArrayList<String>();
        emails = new ArrayList<Email>();
        redesSociales = new ArrayList<RedSocial>();
        contactosRelacionados = new LinkedList<Contacto>();
    }
    

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCodePais() {
        return codePais;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public List<RedSocial> getRedesSociales() {
        return redesSociales;
    }

    public LinkedList<Contacto> getContactosRelacionados() {
        return contactosRelacionados;
    }

    public LinkedList<Integer> getAmigos() {
        return amigos;
    }

    public LinkedList<Integer> getFamiliares() {
        return familiares;
    }

    public LinkedList<Integer> getCompaneros() {
        return companeros;
    }

    public LinkedList<Integer> getFavoritos() {
        return favoritos;
    }
    
    public int getNumInfo(){
        return 0;
    }
    
    public void setFotoPerfil(String foto){
        fotoPerfil = foto;
        fotos.add(fotoPerfil);
    }
    
    public void setDireccion(Direccion d){direccion = d;}
    
    @Override
    public String toString(){
        return String.format("Nombre: %s; Teléfono: %s; CodePais: %s", nombre, telefono, codePais);
    }
    
}
