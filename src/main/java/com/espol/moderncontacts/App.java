package com.espol.moderncontacts;

import com.espol.moderncontacts.model.Contacto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {
    public static String fotoRuta = "src/main/resources/com/espol/moderncontacts/fotos/";
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
<<<<<<< HEAD
        Contacto.setUsuario();
        scene = new Scene(loadFXML("primary"), 480, 720);
=======
        scene = new Scene(loadFXML("createContact"), 480, 720);
>>>>>>> d27f8a224cc08625966462691343315e5c3d635c
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}