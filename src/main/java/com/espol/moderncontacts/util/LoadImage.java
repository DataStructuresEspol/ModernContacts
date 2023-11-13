package com.espol.moderncontacts.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;

public class LoadImage {
    public static Image loadImage(String path) {
        try (FileInputStream fis = new FileInputStream(path)) {
            return new Image(fis);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen");
            return null;
        }
    }

    public static ImagePattern loadPattern(String path) {
        Image img = LoadImage.loadImage(path);
        return new ImagePattern(Objects.requireNonNullElseGet(img, () -> Objects.requireNonNull(LoadImage.loadImage("src/main/resources/com/espol/moderncontacts/fotos/profile.png"))));
    }

    public static String imageDialog() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            return selectedFile.getAbsolutePath();
        }
        return null;
    }
}
