package com.robinthoene.jav42.common.models.user;

/**
 * Specific model of a user to return after a user is created.
 */
public class UserCreatedModel extends UserReadModel {
    /**
     * Get the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password.
     *
     * @param password The new password,
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * The automatic generated, initial user password.
     */
    private String password;
}
