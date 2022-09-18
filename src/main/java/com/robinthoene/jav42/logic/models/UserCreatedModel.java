package com.robinthoene.jav42.logic.models;

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
     * The automatic generated, initial user password.
     */
    private String password;

    /**
     * Whether the user is an admin or not.
     */
    private boolean isAdmin = false;
}
