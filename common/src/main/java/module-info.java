module com.robinthoene.jav42.common {
    requires java.sql;
    requires passay;
    requires spring.beans;
    requires java.xml.bind;
    exports com.robinthoene.jav42.models;
    exports com.robinthoene.jav42.helpers;
}