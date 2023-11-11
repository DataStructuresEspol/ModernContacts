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
public class Persona extends Contacto{
    
    private LocalDate fechaCumple;
    private String apellido;

    public Persona(String nombre, String apellido, String telefono, int codePais) {
        super(nombre, telefono, codePais);
        this.apellido = apellido;
    }

}
