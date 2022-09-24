package com.robinthoene.jav42.coreapi.logic.core;

import com.robinthoene.jav42.common.models.user.UserCreateModel;
import com.robinthoene.jav42.common.models.user.UserCreatedModel;
import com.robinthoene.jav42.common.models.user.UserReadModel;
import com.robinthoene.jav42.common.models.user.UserUpdateModel;
import com.robinthoene.jav42.coreapi.logic.interfaces.IUserLogic;
import com.robinthoene.jav42.coreapi.logic.interfaces.IUserRepository;
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
    public UserReadModel getById(long id) {
        var user = userRepository.getById(id);
        return user;
    }

    @Override
    public List<UserReadModel> getAll() {
        var users = userRepository.getAll();
        return users;
    }

    @Override
    public UserCreatedModel createUser(UserCreateModel createModel) {
        var createdUser = userRepository.createUser(createModel);
        return createdUser;
    }

    @Override
    public UserReadModel updateUser(UserUpdateModel updateModel) {
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
