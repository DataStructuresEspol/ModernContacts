
package com.espol.moderncontacts.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class Persona extends Contacto{
    
    private Date fechaCumple;
    private String apellido;
    private String tipo = "persona";

    public Persona(String nombre, String apellido, String telefono, String codePais) {
        super(nombre, telefono, codePais);
        this.apellido = apellido;
    }
    public String getTipo(){return tipo;}
    
    public void setFechaCumple(Date fecha){fechaCumple = fecha;}
    
     @Override
    public String toString(){
        return super.toString() + String.format("; Apellido: %s", apellido);
    }
    
    public static void main(String args[]){
        Persona p1 = new Persona("Juan", "Alvaro", "0961539738", "593");
        Persona p2 = new Persona("Maria", "Perez", "0915901234", "593");
        Persona p3 = new Persona("Pepe", "Zambrano", "0987654321", "620");
        Persona p4 = new Persona("Pedro", "Murillo", "0978563412", "320");
        Persona p5 = new Persona("Daniel", "Mera", "0918273645", "320");
        
        Empresa e1 = new Empresa("Amazon", "0961530891", "593");
        Empresa e2 = new Empresa("Netflix", "0954637115", "593");
        Empresa e3 = new Empresa("Pepsi", "0998745163", "593");
        Empresa e4 = new Empresa("KFC", "0943237689", "593");
        Empresa e5 = new Empresa("McDonals", "0912465466", "593");
        
        p1.setDireccion(new Direccion("Acacias", TipoDireccion.DOMICILIO));
        p2.setDireccion(new Direccion("Luque y Rumichaca", TipoDireccion.TRABAJO));
        p5.setDireccion(new Direccion("Cerca del Mall", TipoDireccion.DOMICILIO));
        
        e1.setDireccion(new Direccion("Acacias", TipoDireccion.TRABAJO));
        e2.setDireccion(new Direccion("Luque y Rumichaca", TipoDireccion.TRABAJO));
        e3.setDireccion(new Direccion("Policentro", TipoDireccion.TRABAJO));
        e4.setDireccion(new Direccion("Espol", TipoDireccion.TRABAJO));
        
        p3.setFotoPerfil("pepe1.png");
        p3.getFotos().add("pepe2.png");
        p3.getFotos().add("pepe3.png");
        
        p5.setFotoPerfil("daniel1.png");
        p5.getFotos().add("daniel2.png");
        p5.getFotos().add("daniel3.png");
        p5.getFotos().add("daniel4.png");
        p5.getFotos().add("daniel5.png");
        
        p2.setFotoPerfil("maria1.png");
        p2.getFotos().add("maria2.png");
        p2.getFotos().add("maria3.png");
        
        e1.setFotoPerfil("amazon1.png");
        e1.getFotos().add("amazon2.png");
        e1.getFotos().add("amazon3.png");
        e1.getFotos().add("amazon4.png");
        
        e2.setFotoPerfil("netflix1.png");
        e2.getFotos().add("netflix2.png");
        e2.getFotos().add("netflix3.png");
        
        e3.setFotoPerfil("pepsi1.png");
        e3.getFotos().add("pepsi2.png");
        e3.getFotos().add("pepsi3.png");
        e3.getFotos().add("pepsi4.png");
        e3.getFotos().add("pepsi5.png");
        
        e4.setFotoPerfil("kfc1.png");
        e4.getFotos().add("kfc2.png");
        e4.getFotos().add("kfc3.png");
        e4.getFotos().add("kfc4.png");
        e4.getFotos().add("kfc5.png");
        e4.getFotos().add("kfc6.png");
        e4.getFotos().add("kfc7.png");
        
        e5.setFotoPerfil("mc1.png");
        e5.getFotos().add("mc2.png");
        e5.getFotos().add("mc3.png");
        e5.getFotos().add("mc4.png");
        
        
        p4.setFechaCumple(new Date(2023, 6, 1));
        p1.setFechaCumple(new Date(2023, 1, 3));
        p3.setFechaCumple(new Date(2023, 0, 14));
        
        e3.setFechaAniversario(new Date(2023, 1, 1));
        e1.setFechaAniversario(new Date(2023, 7, 23));
        e4.setFechaAniversario(new Date(2023, 8, 15));
        e5.setFechaAniversario(new Date(2023, 9, 6));
        
        
        p4.getEmails().add(new Email("pedromurillo@gmail.com", TipoEmail.PERSONAL));
        p4.getEmails().add(new Email("pedromu@espol.edu.ec", TipoEmail.ESTUDIANTIL));
        
        p5.getEmails().add(new Email("dani45@gmail.com", TipoEmail.PERSONAL));
        p5.getEmails().add(new Email("danifotos@gmail.com", TipoEmail.TRABAJO));
        p5.getEmails().add(new Email("danipapitas@gmail.com", TipoEmail.ESTUDIANTIL));
        
        p1.getEmails().add(new Email("juanAlvaro@gmail.com", TipoEmail.PERSONAL));
        
        p2.getEmails().add(new Email("marialupita@gmail.com", TipoEmail.PERSONAL));
        p2.getEmails().add(new Email("mariaperez@gmail.com", TipoEmail.TRABAJO));
        
        p4.getEmails().add(new Email("pedroZambrano@gmail.com", TipoEmail.TRABAJO));
        
        e1.getEmails().add(new Email("Amazon@gmail.com", TipoEmail.TRABAJO));
        e2.getEmails().add(new Email("Netflix@gmail.com", TipoEmail.TRABAJO));
        e3.getEmails().add(new Email("Pepsi@gmail.com", TipoEmail.TRABAJO));
        e4.getEmails().add(new Email("KFC@gmail.com", TipoEmail.TRABAJO));
        e5.getEmails().add(new Email("McDonals@gmail.com", TipoEmail.TRABAJO));
        
        p5.getRedesSociales().add(new RedSocial("danimalo", TipoRedSocial.FACEBOOK));
        p5.getRedesSociales().add(new RedSocial("dani_insta", TipoRedSocial.INSTAGRAM));
        p5.getRedesSociales().add(new RedSocial("dani_tok", TipoRedSocial.TIKTOK));
        p5.getRedesSociales().add(new RedSocial("dani_mensajes", TipoRedSocial.MESSENGER));
        p5.getRedesSociales().add(new RedSocial("dani_snap", TipoRedSocial.SNAPCHAT));
        p5.getRedesSociales().add(new RedSocial("dani_x", TipoRedSocial.X));
        
        p2.getRedesSociales().add(new RedSocial("Mariafb", TipoRedSocial.FACEBOOK));
        p2.getRedesSociales().add(new RedSocial("Mariatok", TipoRedSocial.TIKTOK));
        p2.getRedesSociales().add(new RedSocial("Mariatuit", TipoRedSocial.X));
        p2.getRedesSociales().add(new RedSocial("Mariareels", TipoRedSocial.INSTAGRAM));
        
        p1.getRedesSociales().add(new RedSocial("Juanito_uwu", TipoRedSocial.X));
        p1.getRedesSociales().add(new RedSocial("Juanito_owo", TipoRedSocial.INSTAGRAM));
        
        p3.getRedesSociales().add(new RedSocial("Pepetiktok", TipoRedSocial.TIKTOK));
        
        p4.getRedesSociales().add(new RedSocial("Pedrito_manguito", TipoRedSocial.INSTAGRAM));
        p4.getRedesSociales().add(new RedSocial("PedroMurillo", TipoRedSocial.FACEBOOK));
        p4.getRedesSociales().add(new RedSocial("Pedrinsta", TipoRedSocial.INSTAGRAM));
        
        e1.getRedesSociales().add(new RedSocial("Amazonfb", TipoRedSocial.FACEBOOK));
        e1.getRedesSociales().add(new RedSocial("Amazon_insta", TipoRedSocial.INSTAGRAM));
        
        e2.getRedesSociales().add(new RedSocial("Netflixfb", TipoRedSocial.FACEBOOK));
        e2.getRedesSociales().add(new RedSocial("Netflix_insta", TipoRedSocial.INSTAGRAM));
        e2.getRedesSociales().add(new RedSocial("Netflix_tiktok", TipoRedSocial.TIKTOK));
        e2.getRedesSociales().add(new RedSocial("Netflix_x", TipoRedSocial.X));
        
        e3.getRedesSociales().add(new RedSocial("Pepsi_insta", TipoRedSocial.INSTAGRAM));
        e3.getRedesSociales().add(new RedSocial("Pepsi_tiktok", TipoRedSocial.TIKTOK));
        e3.getRedesSociales().add(new RedSocial("Pepsi_x", TipoRedSocial.X));
        
        e4.getRedesSociales().add(new RedSocial("KFCfb", TipoRedSocial.FACEBOOK));
        e4.getRedesSociales().add(new RedSocial("KFC_insta", TipoRedSocial.INSTAGRAM));
        e4.getRedesSociales().add(new RedSocial("KFC_tiktok", TipoRedSocial.TIKTOK));
        e4.getRedesSociales().add(new RedSocial("KFC_x", TipoRedSocial.X));
        
        e5.getRedesSociales().add(new RedSocial("MCfb", TipoRedSocial.FACEBOOK));
        e5.getRedesSociales().add(new RedSocial("MC_insta", TipoRedSocial.INSTAGRAM));
        e5.getRedesSociales().add(new RedSocial("MC_tiktok", TipoRedSocial.TIKTOK));
        e5.getRedesSociales().add(new RedSocial("MC_x", TipoRedSocial.X));
        
        p1.getContactosRelacionados().add(p3);
        p1.getContactosRelacionados().add(p5);
        p1.getContactosRelacionados().add(e1);
        p1.getContactosRelacionados().add(e4);
        p1.getContactosRelacionados().add(p2);
        
        p2.getContactosRelacionados().add(p1);
        p2.getContactosRelacionados().add(p4);
        p2.getContactosRelacionados().add(e5);
        p2.getContactosRelacionados().add(e3);
        p2.getContactosRelacionados().add(e1);
        
        p3.getContactosRelacionados().add(p5);
        p3.getContactosRelacionados().add(p4);
        p3.getContactosRelacionados().add(e2);
        
        p4.getContactosRelacionados().add(p2);
        p4.getContactosRelacionados().add(p3);
        p4.getContactosRelacionados().add(e1);
        p4.getContactosRelacionados().add(e2);
        
        p5.getContactosRelacionados().add(p1);
        p5.getContactosRelacionados().add(p3);
        p5.getContactosRelacionados().add(e5);
        p5.getContactosRelacionados().add(e4);
        p5.getContactosRelacionados().add(e3);
        p5.getContactosRelacionados().add(e2);
        p5.getContactosRelacionados().add(e1);
        
        e1.getContactosRelacionados().add(e2);
        e1.getContactosRelacionados().add(e3);
        e1.getContactosRelacionados().add(e4);
        e1.getContactosRelacionados().add(e4);
        
        e2.getContactosRelacionados().add(e1);
        e2.getContactosRelacionados().add(e3);
        e2.getContactosRelacionados().add(e4);
        e2.getContactosRelacionados().add(e5);
        
        e3.getContactosRelacionados().add(e1);
        e3.getContactosRelacionados().add(e2);
        e3.getContactosRelacionados().add(e4);
        
        e4.getContactosRelacionados().add(e5);
        e4.getContactosRelacionados().add(e3);
        e4.getContactosRelacionados().add(e2);
        
        e5.getContactosRelacionados().add(e2);
        e5.getContactosRelacionados().add(e3);
        e5.getContactosRelacionados().add(e4);



        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        contactos.add(p1);
        contactos.add(p2);
        contactos.add(p3);
        contactos.add(p4);
        contactos.add(p5);
        contactos.add(e1);
        contactos.add(e2);
        contactos.add(e3);
        contactos.add(e4);
        contactos.add(e5);
        
        
        String ruta = "src/main/resources/com/espol/moderncontacts/serializables/contactos.ser";
        try {
            FileOutputStream fileOut = new FileOutputStream(ruta);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            Object objetoASerializar;
            out.writeObject(contactos);
            out.close();
            fileOut.close();
            System.out.println("¡Objeto serializado correctamente!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ArrayList<Contacto> objeto = new ArrayList<Contacto>();
        try {
            FileInputStream fileIn = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            objeto = (ArrayList<Contacto>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Contacto c: objeto){System.out.println(c.getContactosRelacionados());}
        
    }

}
