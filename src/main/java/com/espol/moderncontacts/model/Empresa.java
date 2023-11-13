
package com.espol.moderncontacts.model;


import java.util.Date;


public class Empresa extends Contacto{
    private Date fechaAniversario;

    public Empresa(String nombre, String telefono) {
        super(nombre, telefono);
        tipo = "empresa";
    }
    
    public Date getFechaAniversario(){return fechaAniversario;}
    
    public void setFechaAniversario(Date fecha){fechaAniversario = fecha;}
    
     public String getFechaString(){return fechaAniversario.getYear()+"/"+fechaAniversario.getMonth()+"/"+fechaAniversario.getDay();}
    
}
