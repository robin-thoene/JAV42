package com.robinthoene.data.entities;

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
     * The unique database identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The users first name.
     */
    private String firstName;

    /**
     * The users last name.
     */
    private String lastName;
}
