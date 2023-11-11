module com.espol.moderncontacts {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.espol.moderncontacts to javafx.fxml;
    opens com.espol.moderncontacts.controllers to javafx.fxml;
    exports com.espol.moderncontacts;
}
