module com.robinthoene.jav42.common {
    requires passay;
    requires spring.beans;
    requires java.xml.bind;
    exports com.robinthoene.jav42.models;
    exports com.robinthoene.jav42.helpers;
    exports com.robinthoene.jav42.models.user;
}