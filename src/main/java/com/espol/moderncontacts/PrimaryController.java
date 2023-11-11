package com.espol.moderncontacts;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import com.espol.moderncontacts.model.Contacto;
import com.espol.moderncontacts.util.LoadImage;

public class PrimaryController {

    @FXML
    private VBox contacts;

    @FXML
    private ImageView editProfile;

    @FXML
    private Circle profilePic;

    @FXML
    private Label userContactsAmount;

    @FXML
    private Label username;

    @FXML
    private void initialize() throws Exception {
        ImagePattern imagePattern = LoadImage.loadPattern("src/main/resources/com/espol/moderncontacts/images/profile_pic.jpg");
        profilePic.setFill(imagePattern);
        showContacts();
    }

    private void showContacts() {
        for (Contacto contacto: Contacto.getContactos()) {
            // Container to be added to the contacts scroll pane
            HBox contactContainer = new HBox();
            Circle contactPic = new Circle();
            contactPic.setRadius(30);

            String s = "src/main/resources/com/espol/moderncontacts/fotos/";
            ImagePattern imagePattern;

            if (contacto.getFotoPerfil() != null) {
                imagePattern = LoadImage.loadPattern(s + contacto.getFotoPerfil());
            } else {
                imagePattern = LoadImage.loadPattern(s + "profile.png");
            }

            contactPic.setFill(imagePattern);
            Label contactName = new Label(contacto.getNombre());

            contactName.setStyle("-fx-font-size: 20px; -fx-font-weight: 400; -fx-text-fill: #000000; -fx-padding: 0 0 0 10px; -fx-font-family: 'Lato';");

            contactContainer.getChildren().addAll(contactPic, contactName);



            contacts.getChildren().add(contactContainer);
        }
    }
}

