package com.robinthoene.jav42.data.entities;

import javax.persistence.*;

/**
 * Represents a single user in the database.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * Retrieve the unique database identifier of the entity.
     *
     * @return The unique identifier.
     */
    public long getId() {
        return id;
    }

    /**
     * Set the value of the entities unique identifier.
     *
     * @param id The new value for the unique identifier.
     */
    public void setId(long id) {
        this.id = id;
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
     * Retrieve the users login name.
     *
     * @return The username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the users login name.
     *
     * @param userName The new username to use.
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * Set the users hashed password.
     *
     * @param hashedPassword The hashed password of the user.
     */
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
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
     * The unique database identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The users first name.
     */
    @Column
    private String firstName;

    /**
     * The users last name.
     */
    @Column
    private String lastName;

    /**
     * The unique username to use to login.
     */
    @Column(unique = true, nullable = false)
    private String userName;

    /**
     * The users hashed password.
     */
    @Column(nullable = false)
    private String hashedPassword;

    /**
     * Whether the user is an admin or not.
     */
    @Column
    private boolean isAdmin = false;
}
