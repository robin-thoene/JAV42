package com.robinthoene.jav42.logic.interfaces;

import com.robinthoene.jav42.models.user.UserCreateModel;
import com.robinthoene.jav42.models.user.UserCreatedModel;
import com.robinthoene.jav42.models.user.UserReadModel;
import com.robinthoene.jav42.models.user.UserUpdateModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Must be implemented by repositories regarding users.
 */
@Component
public interface IUserRepository {

    /**
     * Retrieves a single user by it's unique identifier.
     *
     * @param id The unique identifier of the desired user.
     * @return The retrieved user.
     */
    UserReadModel getById(long id);

    /**
     * Retrieve all users.
     *
     * @return All users.
     */
    List<UserReadModel> getAll();

    /**
     * Create a single user.
     *
     * @param createModel The model of the user to create.
     * @return The model of the created user.
     */
    UserCreatedModel createUser(UserCreateModel createModel);

    /**
     * Update a single user.
     *
     * @param updateModel The model of the user to update.
     * @return The model of the updated user.
     */
    UserReadModel updateUser(UserUpdateModel updateModel);

    /**
     * Delete a single user.
     *
     * @param id The unique identifier of the user to delete.
     */
    void deleteUser(long id);

    /**
     * Retrieve a user by it's unique username.
     *
     * @param userName The username to search for.
     * @return The retrieved user.
     */
    UserReadModel getByUserName(String userName);

    /**
     * Check if a given hashed password is valid to authenticate a user.
     *
     * @param user         The user to authenticate.
     * @param passwordHash The hashed password to compare with the stored one.
     * @return True, if the password is correct, false if not.
     */
    boolean checkUserPassword(UserReadModel user, String passwordHash);
}
