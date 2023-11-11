package com.espol.moderncontacts.util;

import java.io.FileInputStream;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class LoadImage {
    public static Image loadImage(String path) {
        try (FileInputStream fis = new FileInputStream(path)) {
            return new Image(fis);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ImagePattern loadPattern(String path) {
        Image img = LoadImage.loadImage(path);
        if (img != null) {
            return new ImagePattern(img);
        }
        return null;
    }
}
