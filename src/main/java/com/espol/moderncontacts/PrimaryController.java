package com.espol.moderncontacts;

import java.io.IOException;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import com.espol.moderncontacts.logic.ScrollContacts;
import com.espol.moderncontacts.model.Contacto;
import com.espol.moderncontacts.util.LoadImage;

public class PrimaryController {
    private final String RESOURCES_PATH = "src/main/resources/com/espol/moderncontacts/";

    @FXML
    private VBox contacts;

    @FXML
    private Label currentObservedContactName;

    @FXML
    private Circle currentObservedContactPic;

    @FXML
    private ImageView editProfile;

    @FXML
    private ImageView nextContact;

    @FXML
    private ImageView previousContact;

    @FXML
    private Circle profilePic;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Label userContactsAmount;

    @FXML
    private Label username;

    ScrollContacts scrollContacts;

    @FXML
    private void initialize() {
        showContacts();
        scrollContacts = new ScrollContacts();
    }

    private void showContacts() {
        Contacto.setUsuario();
        /*
        for (Contacto contacto: Contacto.getUserContacts()) {
            // Container to be added to the contacts scroll pane
            HBox contactContainer = new HBox();
            Circle contactPic = new Circle();
            contactPic.setRadius(30);
            String s = RESOURCES_PATH + "fotos/";
            ImagePattern imagePattern;
            if (contacto.getFotoPerfil() != null) {
                imagePattern = LoadImage.loadPattern(s + contacto.getFotoPerfil());
            } else {
                imagePattern = LoadImage.loadPattern(s + "profile.png");
            }
            contactPic.setFill(imagePattern);
            Label contactName = new Label(contacto.getNombre());
            contactContainer.getChildren().addAll(contactPic, contactName);
            contactContainer.setStyle("-fx-padding: 10px 0 10px 0; -fx-background-color: #F2F1F6; -fx-cursor: hand; -fx-alignment: center-left; -fx-spacing: 10px; -fx-border-radius: 0; -fx-background-radius: 10; -fx-pref-width: 350;");
            contactContainer.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css/ContactItem.css")).toExternalForm());
            contacts.getChildren().add(contactContainer);

            contactContainer.setOnMouseClicked(e -> {
                Contacto.setSelectedContact(contacto);
                try {
                    App.setRoot("selected_contact");
                } catch (
                        IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
        */
        userContactsAmount.setText(Contacto.getUserContacts().size() + " contactos");
        username.setText(Contacto.getUser().getNombre());
        ImagePattern imagePattern = LoadImage.loadPattern(RESOURCES_PATH + "fotos/" + Contacto.getUser().getFotoPerfil());
        profilePic.setFill(imagePattern);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");
    }

    @FXML
    private void setNextContact() {
        currentObservedContactName.setText(scrollContacts.nextContact().getNombre());
        ImagePattern imagePattern = LoadImage.loadPattern(RESOURCES_PATH + "fotos/" + scrollContacts.nextContact().getFotoPerfil());
        currentObservedContactPic.setFill(imagePattern);
    }

    @FXML
    private void setPreviousContact() {
        currentObservedContactName.setText(scrollContacts.previousContact().getNombre());
        ImagePattern imagePattern = LoadImage.loadPattern(RESOURCES_PATH + "fotos/" + scrollContacts.previousContact().getFotoPerfil());
        currentObservedContactPic.setFill(imagePattern);
    }
}

