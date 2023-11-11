
package com.espol.moderncontacts.model;


import java.util.Date;


public class Empresa extends Contacto{
    private Date fechaAniversario;
    private String tipo = "empresa";

    public Empresa(String nombre, String telefono, String codePais) {
        super(nombre, telefono, codePais);
    }
    
    public void setFechaAniversario(Date fecha){fechaAniversario = fecha;}
    
    public String getTipo(){return tipo;}
    
}
