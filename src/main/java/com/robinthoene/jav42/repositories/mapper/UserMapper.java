package com.robinthoene.jav42.repositories.mapper;

import com.robinthoene.jav42.data.entities.User;
import com.robinthoene.jav42.logic.models.UserModel;

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
    public static UserModel GetModel(User entity) {
        var model = new UserModel();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        return model;
    }

    /**
     * Map a user model to the entity.
     *
     * @param model The model to map.
     * @return The mapped entity.
     */
    public static User GetEntity(UserModel model) {
        var entity = new User();
        entity.setId(model.getId());
        entity.setLastName(model.getLastName());
        entity.setFirstName(model.getFirstName());
        return entity;
    }
}
