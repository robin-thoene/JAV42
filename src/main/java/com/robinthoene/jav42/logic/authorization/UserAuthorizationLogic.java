package com.robinthoene.jav42.logic.authorization;

import com.robinthoene.jav42.logic.common.exceptions.UserAuthenticationException;
import com.robinthoene.jav42.logic.interfaces.IUserAuthorizationLogic;
import com.robinthoene.jav42.logic.models.UserReadModel;
import org.springframework.stereotype.Component;

/**
 * Logic regarding user authorization.
 */
@Component
public class UserAuthorizationLogic implements IUserAuthorizationLogic {
    @Override
    public UserReadModel AuthenticateUserWithPassword(String userName, String password) throws UserAuthenticationException {
        return null;
    }

    @Override
    public UserReadModel AuthenticateUserWithPasswordHash(String userName, String passwordHash) throws UserAuthenticationException {
        return null;
    }
}
