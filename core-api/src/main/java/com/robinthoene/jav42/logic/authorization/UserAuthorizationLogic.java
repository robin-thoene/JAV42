package com.robinthoene.jav42.logic.authorization;

import com.robinthoene.jav42.logic.common.exceptions.UserAuthenticationException;
import com.robinthoene.jav42.logic.common.exceptions.UserAuthorizationException;
import com.robinthoene.jav42.logic.interfaces.IUserAuthorizationLogic;
import com.robinthoene.jav42.logic.interfaces.IUserRepository;
import com.robinthoene.jav42.logic.models.user.UserReadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Logic regarding user authorization.
 */
@Component
public class UserAuthorizationLogic implements IUserAuthorizationLogic {

    @Override
    public UserReadModel authenticateUser(String userName, String passwordHash) throws UserAuthenticationException {
        var userToCheck = userRepository.getByUserName(userName);
        var isPasswordValid = userRepository.checkUserPassword(userToCheck, passwordHash);
        if (!isPasswordValid) {
            throw new UserAuthenticationException();
        }
        return userToCheck;
    }

    @Override
    public UserReadModel authorizeAdmin(String userName, String passwordHash) throws UserAuthorizationException {
        try {
            var userToCheck = authenticateUser(userName, passwordHash);
            if (!userToCheck.isAdmin()) {
                throw new UserAuthorizationException();
            }
            return userToCheck;
        } catch (UserAuthenticationException exception) {
            throw new UserAuthorizationException();
        }
    }

    @Autowired
    @Lazy
    private IUserRepository userRepository;
}
