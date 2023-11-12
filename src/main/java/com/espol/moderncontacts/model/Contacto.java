
package com.espol.moderncontacts.model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Contacto implements Serializable{
    private static final long serialVersionUID = -7174814431963121356L;

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

    // Every static method/attribute will contain logic to be consumed by controllers
    // No controller will store info

    private static final int USER_ID = 4;
    private static Contacto usuario;
    private static ArrayList<Contacto> contactos;
    private static Contacto selectedContact;

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

    public static void loadContacts() {
        final String RUTA = "src/main/resources/com/espol/moderncontacts/serializables/contactos.ser";
        try (FileInputStream fis = new FileInputStream(RUTA)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Contacto.contactos = (ArrayList<Contacto>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Contacto> getContactos() {
        Contacto.loadContacts();
        return Contacto.contactos;
    }

    // This method will be called by the controller to set the current user
    public static void setUsuario(){
        usuario = getContactos().get(USER_ID);
    }

    // List of contacts related to the current selected user
    public static LinkedList<Contacto> getUserContacts(){
        return usuario.getContactosRelacionados();
    }

    public static int getUserNumberContacts(){
        return usuario.getContactosRelacionados().size();
    }

    // This method will be called by the controller to set the selected contact when clicked
    public static void setSelectedContact(Contacto contacto) {
        Contacto.selectedContact = contacto;
    }

    // This method will be called by the controller to get the selected contact
    public static Contacto getSelectedContact() {
        return Contacto.selectedContact;
    }

    // This method will be called by the controller to get the current user
    public static Contacto getUser() {
        return usuario;
    }


}
