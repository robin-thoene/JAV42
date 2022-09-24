package com.robinthoene.jav42.common.models.user;

/**
 * Represents a single user in the database.
 */
public class UserCreateModel extends BaseUserModel {
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
     * The username.
     */
    private String userName;
}
