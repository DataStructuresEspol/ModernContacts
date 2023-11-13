package com.espol.moderncontacts;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import com.espol.moderncontacts.logic.ScrollContacts;
import com.espol.moderncontacts.model.Contacto;
import com.espol.moderncontacts.util.LoadImage;
import java.io.IOException;
import javafx.scene.input.MouseEvent;

public class PrimaryController {
    public static final String RESOURCES_PATH = "src/main/resources/com/espol/moderncontacts/";

    @FXML
    private Label currentObservedContactName;

    @FXML
    private Circle currentObservedContactPic;

    @FXML
    private ImageView editProfile;

    @FXML
    private Circle profilePic;

    @FXML
    private Label userContactsAmount;

    @FXML
    private Label username;

    ScrollContacts scrollContacts;
    @FXML
    private ImageView previousContact;
    @FXML
    private ImageView nextContact;
    @FXML
    private void initialize(){
        showContacts();
        
    }

    private void showContacts(){
        
        
        scrollContacts = new ScrollContacts();
        setCurrentObservedContact();
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
        
        profilePic.setOnMouseClicked((e)-> {
            try {
                visualizarPerfil(Contacto.getUser());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @FXML
    private void setNextContact() {
        scrollContacts.nextContact();
        setCurrentObservedContact();
    }

    @FXML
    private void setPreviousContact() {
        scrollContacts.previousContact();
        setCurrentObservedContact();
    }

    private void setCurrentObservedContact() {
        currentObservedContactName.setText(scrollContacts.getCurrentObservedContact().getNombre());
        ImagePattern imagePattern = LoadImage.loadPattern(RESOURCES_PATH + "fotos/" + scrollContacts.getCurrentObservedContact().getFotoPerfil());
        currentObservedContactPic.setFill(imagePattern);
        currentObservedContactPic.setOnMouseClicked((e)-> {
            try {
                visualizarPerfil(scrollContacts.getCurrentObservedContact());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        currentObservedContactName.setOnMouseClicked((e)-> {
            try {
                visualizarPerfil(scrollContacts.getCurrentObservedContact());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    @FXML
    private void visualizarPerfil(Contacto c) throws IOException{
        Contacto.setSelectedContact(c);
        App.setRoot("verPerfil");
    }

    @FXML
    private void agregarContacto(MouseEvent event) throws IOException{
        App.setRoot("createContact");
    }
}

