package com.nalaolla.websocket.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nalaolla.websocket.model.ChatMessage;
import com.nalaolla.websocket.model.ChatRoom;
import com.nalaolla.websocket.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws  Exception {
        String payload = message.getPayload();
        log.info("payload >> {}", payload);
//        TextMessage textMessage = new TextMessage("welcome to chatting server....");
//        session.sendMessage(textMessage);

        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        ChatRoom chatRoom = chatService.findRoomById(chatMessage.getRoomId());
        chatRoom.handleAction(session, chatMessage, chatService);
    }
}
