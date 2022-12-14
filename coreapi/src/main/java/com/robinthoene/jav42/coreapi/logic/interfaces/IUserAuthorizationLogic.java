package com.robinthoene.jav42.coreapi.logic.interfaces;

import com.robinthoene.jav42.common.models.user.UserReadModel;
import com.robinthoene.jav42.coreapi.logic.common.exceptions.UserAuthenticationException;
import com.robinthoene.jav42.coreapi.logic.common.exceptions.UserAuthorizationException;
import org.springframework.stereotype.Component;

/**
 * Must be implemented by logic components that handle user authorization.
 */
@Component
public interface IUserAuthorizationLogic {

    /**
     * Try to authenticate a user using the combination of username and password hash.
     *
     * @param userName     The unique username.
     * @param passwordHash The password hash to use for the authentication trial.
     * @return The model of the user, if the authentication attempt is successful.
     * @throws UserAuthenticationException The exception that is thrown if the authentication attempt fails.
     */
    UserReadModel authenticateUser(String userName, String passwordHash) throws UserAuthenticationException;

    /**
     * Try to authorize a user as admin using the combination of username and password hash.
     *
     * @param userName     The unique username.
     * @param passwordHash The password hash to use for the authentication trial.
     * @return The model of the user, if the authorization attempt as admin is successful.
     * @throws UserAuthorizationException The exception that is thrown if the authorization attempt fails.
     */
    UserReadModel authorizeAdmin(String userName, String passwordHash) throws UserAuthorizationException;
}
