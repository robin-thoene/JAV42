package com.robinthoene.jav42.coreapi.repositories.mapper;


import com.robinthoene.jav42.common.models.user.UserCreateModel;
import com.robinthoene.jav42.common.models.user.UserCreatedModel;
import com.robinthoene.jav42.common.models.user.UserReadModel;
import com.robinthoene.jav42.common.models.user.UserUpdateModel;
import com.robinthoene.jav42.coreapi.data.entities.User;

import java.sql.Timestamp;

/**
 * Provides methods to map user entities to models and vice versa.
 */
public final class UserMapper {

    /**
     * Map a user entity to the model.
     *
     * @param entity The entity to map.
     * @return The mapped model.
     */
    public static UserReadModel GetReadModel(User entity) {
        var model = new UserReadModel();
        model.setId(entity.getId());
        model.setUserName(entity.getUserName());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setAdmin(entity.isAdmin());
        model.setCreationTimestamp(entity.getCreationTimestamp());
        model.setLastUpdatedTimestamp(entity.getLastUpdatedTimestamp());
        return model;
    }

    /**
     * Map a user entity to the user created model.
     *
     * @param entity   The entity of the created user.
     * @param password The initial password that was used to create the user.
     * @return The user created model.
     */
    public static UserCreatedModel GetCreatedModel(User entity, String password) {
        var model = new UserCreatedModel();
        model.setId(entity.getId());
        model.setUserName(entity.getUserName());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setPassword(password);
        model.setAdmin(entity.isAdmin());
        model.setCreationTimestamp(entity.getCreationTimestamp());
        model.setLastUpdatedTimestamp(entity.getLastUpdatedTimestamp());
        return model;
    }

    /**
     * Map a user model to the entity.
     *
     * @param model The model to map.
     * @return The mapped entity.
     */
    public static User GetEntityFromReadModel(UserReadModel model) {
        var entity = new User();
        entity.setId(model.getId());
        entity.setUserName(model.getUserName());
        entity.setLastName(model.getLastName());
        entity.setFirstName(model.getFirstName());
        entity.setAdmin(model.isAdmin());
        entity.setCreationTimestamp((Timestamp) model.getCreationTimestamp());
        entity.setLastUpdatedTimestamp((Timestamp) model.getLastUpdatedTimestamp());
        return entity;
    }

    /**
     * Map a user create model to the entity.
     *
     * @param model The creation model to map.
     * @return The mapped entity.
     */
    public static User GetEntityFromCreateModel(UserCreateModel model) {
        var entity = new User();
        entity.setId(model.getId());
        entity.setUserName(model.getUserName());
        entity.setLastName(model.getLastName());
        entity.setFirstName(model.getFirstName());
        entity.setAdmin(model.isAdmin());
        return entity;
    }

    /**
     * Map a user update model to the entity.
     *
     * @param model The update model to map.
     * @return The mapped entity.
     */
    public static User GetEntityFromUpdateModel(UserUpdateModel model) {
        var entity = new User();
        entity.setId(model.getId());
        entity.setLastName(model.getLastName());
        entity.setFirstName(model.getFirstName());
        entity.setAdmin(model.isAdmin());
        return entity;
    }
}
