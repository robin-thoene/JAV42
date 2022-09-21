module com.robinthoene.jav42.uidesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.robinthoene.jav42.common;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens com.robinthoene.jav42.uidesktop to javafx.fxml;
    exports com.robinthoene.jav42.uidesktop;
    exports com.robinthoene.jav42.uidesktop.viewcontrollers;
    opens com.robinthoene.jav42.uidesktop.viewcontrollers to javafx.fxml;
}