package com.forcard.core.messagemanagement.repository;

import com.forcard.core.messagemanagement.model.ContactMessage;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface ContactMessageRepository extends MongoRepository<ContactMessage, ObjectId> {

    Collection<ContactMessage> findByUserId(ObjectId userId);

    Collection<ContactMessage> findAllByStatus(String status);

}
