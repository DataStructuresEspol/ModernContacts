
package com.espol.moderncontacts.model;

import java.io.Serializable;

public class Direccion implements Serializable{
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
