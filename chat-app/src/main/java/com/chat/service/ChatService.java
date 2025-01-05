package com.chat.service;

import com.chat.model.Message;
import com.chat.model.User;
import com.chat.repository.MessageRepository;
import com.chat.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public ChatService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public void sendMessage(Message message) {
        messageRepository.save(message);
    }

    public List<Message> getMessagesForUser(String userId) {
        return messageRepository.findByRecipientId(userId);
    }

    public List<Message> getMessagesForGroup(String groupId) {
        return messageRepository.findByGroupId(groupId);
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}