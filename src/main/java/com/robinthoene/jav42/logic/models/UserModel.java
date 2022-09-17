package com.robinthoene.jav42.logic.models;

/**
 * Represents a single user in the database.
 */
public class UserModel extends BaseModel {

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
     * Retrieve the users hashed password.
     *
     * @return The users hashed password.
     */
    public String getHashedPassword() {
        return hashedPassword;
    }

    /**
     * Set teh users hashed password.
     *
     * @param hashedPassword The hashed password of the user.
     */
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    /**
     * The users first name.
     */
    private String firstName;

    /**
     * The users last name.
     */
    private String lastName;

    /**
     * The users hashed password.
     */
    private String hashedPassword;
}
