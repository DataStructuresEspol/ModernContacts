
package com.espol.moderncontacts.model;

import java.io.Serializable;


public class Email implements Serializable{
    private String email;
    private TipoEmail tipoEmail;

    public Email(String email, TipoEmail tipoEmail) {
        this.email = email;
        this.tipoEmail = tipoEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoEmail getTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(TipoEmail tipoEmail) {
        this.tipoEmail = tipoEmail;
    }
    
    @Override
    public String toString(){
        return String.format("%s: %s", tipoEmail,email);
    }
    
    
}
