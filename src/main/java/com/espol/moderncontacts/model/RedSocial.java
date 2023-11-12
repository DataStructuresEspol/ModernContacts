
package com.espol.moderncontacts.model;

import java.io.Serializable;

public class RedSocial implements Serializable{
    private String red;
    private TipoRedSocial tipoRedSocial;

    public RedSocial(String red, TipoRedSocial tipoRedSocial) {
        this.red = red;
        this.tipoRedSocial = tipoRedSocial;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public TipoRedSocial getTipoRedSocial() {
        return tipoRedSocial;
    }

    public void setTipoRedSocial(TipoRedSocial tipoRedSocial) {
        this.tipoRedSocial = tipoRedSocial;
    }
    
    @Override
    public String toString(){
        return String.format("%s: %s", tipoRedSocial,red);
    }
    
    
}
