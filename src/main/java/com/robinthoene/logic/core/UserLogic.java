package com.robinthoene.logic.core;

import com.robinthoene.logic.interfaces.IUserLogic;
import com.robinthoene.logic.interfaces.IUserRepository;
import com.robinthoene.logic.models.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Logic regarding users.
 */
@Component
public class UserLogic implements IUserLogic {

    /**
     * Default constructor.
     *
     * @param userRepository The injected user repository.
     */
    public UserLogic(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel getById(long id) {
        return null;
    }

    @Override
    public List<UserModel> getAll() {
        return null;
    }

    @Override
    public UserModel createUser(UserModel createModel) {
        return null;
    }

    @Override
    public UserModel updateUser(UserModel updateModel) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }

    /**
     * The injected user repository.
     */
    private IUserRepository userRepository;
}
