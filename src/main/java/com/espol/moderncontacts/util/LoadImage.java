package com.espol.moderncontacts.util;

import com.espol.moderncontacts.App;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
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
        File directorioInicial = new File(App.fotoRuta);
        fileChooser.setInitialDirectory(directorioInicial);
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            String rutaAbsoluta = selectedFile.getAbsolutePath();
            String rutaBase = Paths.get(App.fotoRuta).toAbsolutePath().toString();
            String rutaRelativa = Paths.get(rutaBase).relativize(Paths.get(rutaAbsoluta)).toString();
            return rutaRelativa;
        }
        return null;
    }
}
