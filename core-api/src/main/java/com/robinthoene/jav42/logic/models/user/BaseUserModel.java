package com.robinthoene.jav42.logic.models.user;

import com.robinthoene.jav42.logic.models.BaseModel;

import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * Model from that all user models must inherit.
 */
public abstract class BaseUserModel extends BaseModel {
    /**
     * Get the current value of the users last name.
     *
     * @return The users last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the current value for the users last name.
     *
     * @param lastName The new value for the users last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the current value of the users first name.
     *
     * @return The users first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the current value for the users first name.
     *
     * @param firstName The new value for the users first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieve whether the user is an admin or not.
     *
     * @return The current admin state.
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Set whether the user is an admin or not.
     *
     * @param admin The new admin state.
     */
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    /**
     * The users last name.
     */
    private String lastName;

    /**
     * The users first name.
     */
    private String firstName;

    /**
     * Whether the user is an admin or not.
     */
    private boolean isAdmin = false;
}
