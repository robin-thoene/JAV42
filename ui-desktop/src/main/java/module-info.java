module com.robinthoene.jav42.uidesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;


    opens com.robinthoene.jav42.uidesktop to javafx.fxml;
    exports com.robinthoene.jav42.uidesktop;
    exports com.robinthoene.jav42.uidesktop.viewcontrollers;
    opens com.robinthoene.jav42.uidesktop.viewcontrollers to javafx.fxml;
}