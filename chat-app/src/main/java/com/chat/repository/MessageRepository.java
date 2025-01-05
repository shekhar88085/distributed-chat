package com.chat.repository;

import com.chat.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    // Find messages by recipientId (one-to-one chat)
    List<Message> findByRecipientId(String recipientId);

    // Find messages by groupId (group chat)
    List<Message> findByGroupId(String groupId);
}