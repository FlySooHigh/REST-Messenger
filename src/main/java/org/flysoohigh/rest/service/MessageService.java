package org.flysoohigh.rest.service;

import org.flysoohigh.rest.database.DatabaseClass;
import org.flysoohigh.rest.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created on 24.12.2018.
 */
public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1L, "Message #1", "Alex"));
        messages.put(2L, new Message(2L, "Message #2", "Alex"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1L);
        messages.put(message.getId(), message);
        return message;
    }

    public Message getMessage(long id) {
        return messages.get(id);
    }

    public Message updateMessage(Message message) {
        if (messages.size() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
