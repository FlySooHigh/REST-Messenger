package org.flysoohigh.rest.service;

import org.flysoohigh.rest.database.DatabaseStub;
import org.flysoohigh.rest.exceptions.DataNotFoundException;
import org.flysoohigh.rest.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created on 24.12.2018.
 */
public class MessageService {

    private Map<Long, Message> messages = DatabaseStub.getMessages();

    public MessageService() {
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
        Message message = messages.get(id);
        if (message == null) {
            throw new DataNotFoundException("Message with id: " + id + " not found.");
        }
        return messages.get(id);
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }

    public List<Message> getFilteredByYear(int year) {
        List<Message> filteredList = new ArrayList<>();
        for (Message message : messages.values()) {
            if (message.getDateTime().getYear() == year) {
                filteredList.add(message);
            }
        }
        return filteredList;
    }

    public List<Message> getPaginatedList(int start, int size) {
        List<Message> fullMessageList = new ArrayList<>(this.messages.values());
        return fullMessageList.subList(start, start + size);
    }
}
