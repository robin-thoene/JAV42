package com.robinthoene.repositories.core;

import com.robinthoene.logic.interfaces.ICrudUserRepository;
import com.robinthoene.logic.interfaces.IUserRepository;
import com.robinthoene.logic.models.UserModel;
import com.robinthoene.repositories.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Repository regarding users.
 */
@Component
public class UserRepository implements IUserRepository {

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
        var userToCreate = UserMapper.GetEntity(createModel);
        var user = crudUserRepository.save(userToCreate);
        var createdUserModel = UserMapper.GetModel(user);
        return createdUserModel;
    }

    @Override
    public UserModel updateUser(UserModel updateModel) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }

    /**
     * The injected CRUD repository to access users in the database.
     */
    @Autowired
    @Lazy
    private ICrudUserRepository crudUserRepository;
}
