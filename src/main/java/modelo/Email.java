/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ariel
 */
public class Email {
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
    
    
}
