package com.forcard.core.usermanagement.repository;

import com.forcard.core.usermanagement.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

}
