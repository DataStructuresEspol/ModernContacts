/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ariel
 */
public class Contacto {
    private String nombre;
    private int id;
    private String telefono;
    private int codePais;
    private String fotoPerfil;
    private List<String> fotos;
    private Direccion direccion;
    private List<Email> emails;
    private List<String> id_social;
    private LinkedList<Contacto> contactosRelacionados;
    private LinkedList<Integer> amigos;
    private LinkedList<Integer> familiares;
    private LinkedList<Integer> familias;
    private LinkedList<Integer> companeros;
    private LinkedList<Integer> favoritos;

    public Contacto(String nombre, String telefono, int codePais) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.codePais = codePais;
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

    public int getCodePais() {
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

    public List<String> getId_social() {
        return id_social;
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

    public LinkedList<Integer> getFamilias() {
        return familias;
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
    
}
