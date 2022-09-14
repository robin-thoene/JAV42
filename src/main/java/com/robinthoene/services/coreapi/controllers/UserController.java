package com.robinthoene.services.coreapi.controllers;

import com.robinthoene.logic.interfaces.IUserLogic;
import com.robinthoene.logic.models.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

/**
 * Provides endpoints regarding users.
 */
@RestController
public class UserController {

    /**
     * Default constructor.
     *
     * @param userLogic The injected user logic.
     */
    public UserController(IUserLogic userLogic) {
        this.userLogic = userLogic;
    }

    /**
     * Retrieves a single user by it's unique identifier.
     *
     * @param id The unique identifier of the desired user.
     * @return The retrieved user.
     */
    @RequestMapping(method = RequestMethod.GET, path = "user/{id}")
    public ResponseEntity<UserModel> getById(@PathVariable long id) {
        var user = userLogic.getById(id);
        return ok(user);
    }

    /**
     * Retrieve all users.
     *
     * @return All users.
     */
    @RequestMapping(method = RequestMethod.GET, path = "user")
    public ResponseEntity<List<UserModel>> getAll() {
        var allUsers = userLogic.getAll();
        return ok(allUsers);
    }

    /**
     * Create a single user.
     *
     * @param createModel The model of the user to create.
     * @return The model of the created user.
     */
    @RequestMapping(method = RequestMethod.POST, path = "user")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel createModel) {
        var createdUser = userLogic.createUser(createModel);
        return ok(createdUser);
    }

    /**
     * Update a single user.
     *
     * @param updateModel The model of the user to update.
     * @return The model of the updated user.
     */
    @RequestMapping(method = RequestMethod.PUT, path = "user")
    public ResponseEntity<UserModel> updateUser(@RequestBody UserModel updateModel) {
        var updatedUser = userLogic.updateUser(updateModel);
        return ok(updatedUser);
    }

    /**
     * Delete a single user.
     *
     * @param id The unique identifier of the user to delete.
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "user")
    public ResponseEntity deleteUser(@PathVariable long id) {
        userLogic.deleteUser(id);
        return ok().build();
    }


    /**
     * The injected user logic.
     */
    private IUserLogic userLogic;
}
