package com.robinthoene.logic.interfaces;

import com.robinthoene.data.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * Auto generated CRUD repository to access users from the database.
 */
@Component
public interface ICrudUserRepository extends CrudRepository<User, Long> {
}
