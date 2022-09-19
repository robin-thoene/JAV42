package com.robinthoene.jav42.logic.models.user;

import com.robinthoene.jav42.logic.models.BaseModel;

import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * Represents a single user in the database.
 */
public class UserReadModel extends BaseUserModel {
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
     * Get the creation timestamp.
     *
     * @return The creation timestamp.
     */
    public Timestamp getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * Set the creation timestamp.
     *
     * @param creationTimestamp The new creation timestamp.
     */
    public void setCreationTimestamp(Timestamp creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    /**
     * Get the last update timestamp.
     *
     * @return The last update timestamp.
     */
    public Timestamp getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    /**
     * Set the timestamp for last user update.
     *
     * @param lastUpdatedTimestamp The new last update timestamp.
     */
    public void setLastUpdatedTimestamp(Timestamp lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    /**
     * The timestamp for the user creation.
     */
    @Column(nullable = false)
    private Timestamp creationTimestamp;

    /**
     * The timestamp for the last user update.
     */
    private Timestamp lastUpdatedTimestamp;

    /**
     * The username.
     */
    private String userName;
}
