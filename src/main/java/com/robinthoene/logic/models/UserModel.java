package com.robinthoene.logic.models;

/**
 * Represents a single user in the database.
 */
public class UserModel extends BaseModel {

    /**
     * Default constructor.
     *
     * @param id The initial value of the models unique database identifier.
     */
    public UserModel(long id) {
        super(id);
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
     * The users first name.
     */
    private String firstName;

    /**
     * The users last name.
     */
    private String lastName;
}
