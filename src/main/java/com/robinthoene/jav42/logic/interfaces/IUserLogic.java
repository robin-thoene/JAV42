package com.robinthoene.jav42.logic.interfaces;

import com.robinthoene.jav42.logic.models.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Must be implemented byt logic components regarding users.
 */
@Component
public interface IUserLogic {
    /**
     * Retrieves a single user by it's unique identifier.
     *
     * @param id The unique identifier of the desired user.
     * @return The retrieved user.
     */
    UserModel getById(long id);

    /**
     * Retrieve all users.
     *
     * @return All users.
     */
    List<UserModel> getAll();

    /**
     * Create a single user.
     *
     * @param createModel The model of the user to create.
     * @return The model of the created user.
     */
    UserModel createUser(UserModel createModel);

    /**
     * Update a single user.
     *
     * @param updateModel The model of the user to update.
     * @return The model of the updated user.
     */
    UserModel updateUser(UserModel updateModel);

    /**
     * Delete a single user.
     *
     * @param id The unique identifier of the user to delete.
     */
    void deleteUser(long id);
}
