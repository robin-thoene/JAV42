package com.robinthoene.jav42.coreapi.repositories.core;

import com.robinthoene.jav42.common.helpers.PasswordHelper;
import com.robinthoene.jav42.common.models.user.UserCreateModel;
import com.robinthoene.jav42.common.models.user.UserCreatedModel;
import com.robinthoene.jav42.common.models.user.UserReadModel;
import com.robinthoene.jav42.common.models.user.UserUpdateModel;
import com.robinthoene.jav42.coreapi.logic.interfaces.ICrudUserRepository;
import com.robinthoene.jav42.coreapi.logic.interfaces.IUserRepository;
import com.robinthoene.jav42.coreapi.repositories.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository regarding users.
 */
@Component
public class UserRepository implements IUserRepository {

    @Override
    public UserReadModel getById(long id) {
        var user = crudUserRepository.findById(id).orElseThrow();
        var userModel = UserMapper.GetReadModel(user);
        return userModel;
    }

    @Override
    public List<UserReadModel> getAll() {
        var users = crudUserRepository.findAll();
        var userModels = new ArrayList<UserReadModel>();
        users.forEach((user) -> {
            var model = UserMapper.GetReadModel(user);
            userModels.add(model);
        });
        return userModels;
    }

    @Override
    public UserCreatedModel createUser(UserCreateModel createModel) {
        // Map the user model to the entity.
        var userToCreate = UserMapper.GetEntityFromCreateModel(createModel);
        // Create an initial password for the new user.
        var initialPassword = PasswordHelper.createRandomPassword();
        // Hash the password to store it in the database.
        var hashedPassword = PasswordHelper.hashPassword(initialPassword);
        // Assign the password.
        userToCreate.setHashedPassword(hashedPassword);
        // Update the timestamps.
        var now = new Timestamp(System.currentTimeMillis());
        userToCreate.setCreationTimestamp(now);
        userToCreate.setLastUpdatedTimestamp(now);
        // Create the user.
        var user = crudUserRepository.save(userToCreate);
        // Map the created user to the corresponding model using the created entity and the used initial password.
        var createdUserModel = UserMapper.GetCreatedModel(user, initialPassword);
        // Return the result.
        return createdUserModel;
    }

    @Override
    public UserReadModel updateUser(UserUpdateModel updateModel) {
        // Map the model to the entity to update.
        var userToUpdate = UserMapper.GetEntityFromUpdateModel(updateModel);
        // Get the current entity.
        var currentUser = crudUserRepository.findById(userToUpdate.getId()).orElseThrow();
        // Persist the password and username.
        userToUpdate.setUserName(currentUser.getUserName());
        userToUpdate.setHashedPassword(currentUser.getHashedPassword());
        // Set the last update timestamp.
        userToUpdate.setLastUpdatedTimestamp(new Timestamp(System.currentTimeMillis()));
        // Ensure the created timestamp stays the same.
        userToUpdate.setCreationTimestamp(currentUser.getCreationTimestamp());
        // Update the user.
        var user = crudUserRepository.save(userToUpdate);
        var updatedUser = UserMapper.GetReadModel(user);
        return updatedUser;
    }

    @Override
    public void deleteUser(long id) {
        crudUserRepository.deleteById(id);
    }

    @Override
    public UserReadModel getByUserName(String userName) {
        var user = crudUserRepository.getByUserName(userName).orElseThrow();
        var userModel = UserMapper.GetReadModel(user);
        return userModel;
    }

    @Override
    public boolean checkUserPassword(UserReadModel user, String passwordHash) {
        var databaseUser = crudUserRepository.findById(user.getId()).orElseThrow();
        return passwordHash.equals(databaseUser.getHashedPassword());
    }

    /**
     * The injected CRUD repository to access users in the database.
     */
    @Autowired
    @Lazy
    private ICrudUserRepository crudUserRepository;
}
