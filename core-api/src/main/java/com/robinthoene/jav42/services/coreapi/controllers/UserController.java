package com.robinthoene.jav42.services.coreapi.controllers;

import com.robinthoene.jav42.logic.common.exceptions.UserAuthorizationException;
import com.robinthoene.jav42.logic.interfaces.IUserAuthorizationLogic;
import com.robinthoene.jav42.logic.interfaces.IUserLogic;
import com.robinthoene.jav42.models.user.UserCreateModel;
import com.robinthoene.jav42.models.user.UserReadModel;
import com.robinthoene.jav42.models.user.UserUpdateModel;
import org.springframework.http.HttpStatus;
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
     * @param userLogic              The injected user logic.
     * @param userAuthorizationLogic The injected logic regarding user authorization.
     */
    public UserController(IUserLogic userLogic, IUserAuthorizationLogic userAuthorizationLogic) {
        this.userLogic = userLogic;
        this.userAuthorizationLogic = userAuthorizationLogic;
    }

    /**
     * Retrieves a single user by it's unique identifier.
     *
     * @param id The unique identifier of the desired user.
     * @return The retrieved user.
     */
    @RequestMapping(method = RequestMethod.GET, path = "user/{id}")
    public ResponseEntity<UserReadModel> getById(@PathVariable long id, @RequestHeader(value = "user-name") String requestCallerUserName, @RequestHeader(value = "password") String requestCallerPasswordHash) {
        try {
            userAuthorizationLogic.authorizeAdmin(requestCallerUserName, requestCallerPasswordHash);
            var user = userLogic.getById(id);
            return ok(user);
        } catch (UserAuthorizationException ex) {
            return new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Retrieve all users.
     *
     * @return All users.
     */
    @RequestMapping(method = RequestMethod.GET, path = "user")
    public ResponseEntity<List<UserReadModel>> getAll(@RequestHeader(value = "user-name") String requestCallerUserName, @RequestHeader(value = "password") String requestCallerPasswordHash) {
        try {
            userAuthorizationLogic.authorizeAdmin(requestCallerUserName, requestCallerPasswordHash);
            var allUsers = userLogic.getAll();
            return ok(allUsers);
        } catch (UserAuthorizationException ex) {
            return new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Create a single user.
     *
     * @param createModel The model of the user to create.
     * @return The model of the created user.
     */
    @RequestMapping(method = RequestMethod.POST, path = "user")
    public ResponseEntity<UserReadModel> createUser(@RequestBody UserCreateModel createModel, @RequestHeader(value = "user-name") String requestCallerUserName, @RequestHeader(value = "password") String requestCallerPasswordHash) {
        try {
            userAuthorizationLogic.authorizeAdmin(requestCallerUserName, requestCallerPasswordHash);
            var createdUser = userLogic.createUser(createModel);
            return ok(createdUser);
        } catch (UserAuthorizationException ex) {
            return new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Update a single user.
     *
     * @param updateModel The model of the user to update.
     * @return The model of the updated user.
     */
    @RequestMapping(method = RequestMethod.PUT, path = "user")
    public ResponseEntity<UserReadModel> updateUser(@RequestBody UserUpdateModel updateModel, @RequestHeader(value = "user-name") String requestCallerUserName, @RequestHeader(value = "password") String requestCallerPasswordHash) {
        try {
            userAuthorizationLogic.authorizeAdmin(requestCallerUserName, requestCallerPasswordHash);
            var updatedUser = userLogic.updateUser(updateModel);
            return ok(updatedUser);
        } catch (UserAuthorizationException ex) {
            return new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Delete a single user.
     *
     * @param id The unique identifier of the user to delete.
     */
    @RequestMapping(method = RequestMethod.DELETE, path = "user/{id}")
    public ResponseEntity deleteUser(@PathVariable long id, @RequestHeader(value = "user-name") String requestCallerUserName, @RequestHeader(value = "password") String requestCallerPasswordHash) {
        try {
            userAuthorizationLogic.authorizeAdmin(requestCallerUserName, requestCallerPasswordHash);
            userLogic.deleteUser(id);
            return ok().build();
        } catch (UserAuthorizationException ex) {
            return new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Authorize a user as admin.
     *
     * @return 200, if the given username and password are correct and if the user is an admin, else 401.
     */
    @RequestMapping(method = RequestMethod.POST, path = "user/authorize-as-admin")
    public ResponseEntity<UserReadModel> authorizeAsAdmin(@RequestHeader(value = "user-name") String requestCallerUserName, @RequestHeader(value = "password") String requestCallerPasswordHash) {
        try {
            var user = userAuthorizationLogic.authorizeAdmin(requestCallerUserName, requestCallerPasswordHash);
            return ok(user);
        } catch (UserAuthorizationException ex) {
            return new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }


    /**
     * The injected user logic.
     */
    private IUserLogic userLogic;

    /**
     * The injected logic regarding user authorization.
     */
    private IUserAuthorizationLogic userAuthorizationLogic;
}
