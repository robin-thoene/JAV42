package com.robinthoene.jav42.repositories.core;

import com.robinthoene.jav42.logic.interfaces.ICrudUserRepository;
import com.robinthoene.jav42.logic.interfaces.IUserRepository;
import com.robinthoene.jav42.logic.models.UserModel;
import com.robinthoene.jav42.repositories.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository regarding users.
 */
@Component
public class UserRepository implements IUserRepository {

    @Override
    public UserModel getById(long id) {
        var user = crudUserRepository.findById(id).orElseThrow();
        var userModel = UserMapper.GetModel(user);
        return userModel;
    }

    @Override
    public List<UserModel> getAll() {
        var users = crudUserRepository.findAll();
        var userModels = new ArrayList<UserModel>();
        users.forEach((user) -> {
            var model = UserMapper.GetModel(user);
            userModels.add(model);
        });
        return userModels;
    }

    @Override
    public UserModel createUser(UserModel createModel) {
        var userToCreate = UserMapper.GetEntity(createModel);
        var user = crudUserRepository.save(userToCreate);
        var createdUserModel = UserMapper.GetModel(user);
        return createdUserModel;
    }

    @Override
    public UserModel updateUser(UserModel updateModel) {
        var userToUpdate = UserMapper.GetEntity(updateModel);
        var user = crudUserRepository.save(userToUpdate);
        var updatedUser = UserMapper.GetModel(user);
        return updatedUser;
    }

    @Override
    public void deleteUser(long id) {
        crudUserRepository.deleteById(id);
    }

    /**
     * The injected CRUD repository to access users in the database.
     */
    @Autowired
    @Lazy
    private ICrudUserRepository crudUserRepository;
}
