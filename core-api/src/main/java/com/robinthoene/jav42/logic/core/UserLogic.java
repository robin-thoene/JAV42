package com.robinthoene.jav42.logic.core;

import com.robinthoene.jav42.logic.interfaces.IUserLogic;
import com.robinthoene.jav42.logic.interfaces.IUserRepository;
import com.robinthoene.jav42.logic.models.UserCreateModel;
import com.robinthoene.jav42.logic.models.UserCreatedModel;
import com.robinthoene.jav42.logic.models.UserReadModel;
import com.robinthoene.jav42.logic.models.UserUpdateModel;
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
