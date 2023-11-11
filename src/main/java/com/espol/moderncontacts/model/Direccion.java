/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ariel
 */
public class Direccion {
    private String direccion;
    private String linkDireccion;
    private TipoDireccion tipoDireccion;

    public Direccion(String direccion, TipoDireccion tipoDireccion) {
        this.direccion = direccion;
        this.tipoDireccion = tipoDireccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLinkDireccion() {
        return linkDireccion;
    }

    public void setLinkDireccion(String linkDireccion) {
        this.linkDireccion = linkDireccion;
    }

    public TipoDireccion getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(TipoDireccion tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }
    
    
}
