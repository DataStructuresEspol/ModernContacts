
package com.espol.moderncontacts.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ModelUtils {
    public static String getPais(String code){
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
    
    public static Image getImage(String ruta){
        Image img = null;
        try{
            FileInputStream input = new FileInputStream(ruta);
            img = new Image(input);
        }
        catch(Exception e){e.printStackTrace();}
        
        return img;
    }
}
