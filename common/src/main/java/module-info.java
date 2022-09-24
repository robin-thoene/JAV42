module com.robinthoene.jav42.common {
    requires passay;
    requires spring.beans;
    requires java.xml.bind;
    exports com.robinthoene.jav42.common.models;
    exports com.robinthoene.jav42.common.helpers;
    exports com.robinthoene.jav42.common.models.user;
}