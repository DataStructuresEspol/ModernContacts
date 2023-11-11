/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author ariel
 */
public class Empresa extends Contacto{
    private LocalDate fechaAniversario;

    public Empresa(String nombre, String telefono, String codePais) {
        super(nombre, telefono, codePais);
    }
    
}
