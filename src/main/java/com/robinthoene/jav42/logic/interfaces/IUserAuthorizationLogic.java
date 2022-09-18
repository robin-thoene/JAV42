package com.robinthoene.jav42.logic.interfaces;

import com.robinthoene.jav42.logic.common.exceptions.UserAuthenticationException;
import com.robinthoene.jav42.logic.models.UserReadModel;
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
    UserReadModel authenticateUserWithPasswordHash(String userName, String passwordHash) throws UserAuthenticationException;
}
