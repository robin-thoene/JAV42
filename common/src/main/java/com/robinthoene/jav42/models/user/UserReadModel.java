package com.robinthoene.jav42.models.user;

import java.util.Date;

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
    public Date getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * Set the creation timestamp.
     *
     * @param creationTimestamp The new creation timestamp.
     */
    public void setCreationTimestamp(Date creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    /**
     * Get the last update timestamp.
     *
     * @return The last update timestamp.
     */
    public Date getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    /**
     * Set the timestamp for last user update.
     *
     * @param lastUpdatedTimestamp The new last update timestamp.
     */
    public void setLastUpdatedTimestamp(Date lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    /**
     * The timestamp for the user creation.
     */
    private Date creationTimestamp;

    /**
     * The timestamp for the last user update.
     */
    private Date lastUpdatedTimestamp;

    /**
     * The username.
     */
    private String userName;
}
