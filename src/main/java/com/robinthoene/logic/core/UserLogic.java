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
        var user = userRepository.getById(id);
        return user;
    }

    @Override
    public List<UserModel> getAll() {
        var users = userRepository.getAll();
        return users;
    }

    @Override
    public UserModel createUser(UserModel createModel) {
        var createdUser = userRepository.createUser(createModel);
        return createdUser;
    }

    @Override
    public UserModel updateUser(UserModel updateModel) {
        var user = userRepository.updateUser(updateModel);
        return user;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }

    /**
     * The injected user repository.
     */
    private IUserRepository userRepository;
}
