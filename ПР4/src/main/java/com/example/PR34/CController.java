package com.example.PR34;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CController {
    @MessageMapping("/webs")
    @SendTo("/topic/messages")
    public Chat send(Chat message) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new Chat(message.getFrom(), message.getText(), time);
    }

}
