module com.robinthoene.uidesktop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.robinthoene.uidesktop to javafx.fxml;
    exports com.robinthoene.uidesktop;
}