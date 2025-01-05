package com.chat.controller;

import com.chat.model.Message;
import com.chat.model.User;
import com.chat.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChatController {

    private final ChatService chatService;
    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(ChatService chatService, SimpMessagingTemplate messagingTemplate) {
        this.chatService = chatService;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        chatService.registerUser(user);
        return "redirect:/dashboard";
    }

    @MessageMapping("/sendMessage")
    public void sendMessage(Message message) {
        chatService.sendMessage(message);
        if (message.getGroupId() != null) {
            messagingTemplate.convertAndSend("/topic/group/" + message.getGroupId(), message);
        } else {
            messagingTemplate.convertAndSend("/topic/user/" + message.getRecipientId(), message);
        }
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/getMessages")
    public List<Message> getMessages(@RequestParam String userId) {
        return chatService.getMessagesForUser(userId);
    }

    @GetMapping("/getGroupMessages")
    public List<Message> getGroupMessages(@RequestParam String groupId) {
        return chatService.getMessagesForGroup(groupId);
    }
}