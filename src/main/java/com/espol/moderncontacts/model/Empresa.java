
package com.espol.moderncontacts.model;


import java.util.Date;


public class Empresa extends Contacto{
    private Date fechaAniversario;

    public Empresa(String nombre, String telefono, String codePais) {
        super(nombre, telefono, codePais);
        tipo = "empresa";
    }
    
    public void setFechaAniversario(Date fecha){fechaAniversario = fecha;}
    
    public String getTipo(){return tipo;}
    
}
