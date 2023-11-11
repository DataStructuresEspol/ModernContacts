/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ariel
 */
public class Util {
    public String getPais(String code){
        String pais = "";
        try(BufferedReader br = new BufferedReader(new FileReader("codePais.txt"))){
            String line;
            String[] codigos;
            while((line = br.readLine()) != null){
                codigos = line.split(", ");
                if(code.equals(codigos[1])){
                    pais = codigos[0];
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return pais;
    }
}
