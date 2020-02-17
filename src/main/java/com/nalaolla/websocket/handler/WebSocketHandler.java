package com.nalaolla.websocket.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.xml.soap.Text;

@Component
@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws  Exception {
        String payload = message.getPayload();
        log.info("payload >> {}", payload);
        TextMessage textMessage = new TextMessage("welcome to chatting server....");
        session.sendMessage(textMessage);
    }
}
