package com.robinthoene.repositories.core;

import com.robinthoene.logic.interfaces.IUserRepository;
import com.robinthoene.logic.models.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Repository regarding users.
 */
@Component
public class UserRepository implements IUserRepository {

    /**
     * Default constructor.
     */
    public UserRepository() {
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
}
