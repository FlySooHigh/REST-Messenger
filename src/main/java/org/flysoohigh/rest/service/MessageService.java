package org.flysoohigh.rest.service;

import org.flysoohigh.rest.model.Message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 24.12.2018.
 */
public class MessageService {

    public List<Message> getAllMessages() {
        Message m1 = new Message(1L, "Message #1", "Alex");
        Message m2 = new Message(2L, "Message #2", "Alex");
        List<Message> messages = new ArrayList<>();
        messages.add(m1);
        messages.add(m2);
        return messages;
    }
}
