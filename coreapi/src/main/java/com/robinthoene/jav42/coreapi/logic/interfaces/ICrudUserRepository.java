package com.robinthoene.jav42.coreapi.logic.interfaces;

import com.robinthoene.jav42.coreapi.data.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Auto generated CRUD repository to access users from the database.
 */
@Component
public interface ICrudUserRepository extends CrudRepository<User, Long> {
    @Query(value = "select * from users where user_name = ?1", nativeQuery = true)
    Optional<User> getByUserName(String userName);
}
