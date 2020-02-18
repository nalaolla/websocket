package com.nalaolla.websocket.controller;

import com.nalaolla.websocket.service.ChatService;
import com.nalaolla.websocket.model.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ChatRoom createRoom(@RequestParam String roomName) {
        return chatService.createRoom(roomName);
    }

    @GetMapping
    public List<ChatRoom> finaAllRoom() {
        return chatService.findAllRoom();
    }
}
