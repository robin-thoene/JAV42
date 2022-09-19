module com.robinthoene.jav42.uidesktop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.robinthoene.jav42.uidesktop to javafx.fxml;
    exports com.robinthoene.jav42.uidesktop;
}