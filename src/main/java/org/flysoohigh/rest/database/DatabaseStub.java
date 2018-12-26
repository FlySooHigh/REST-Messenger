package org.flysoohigh.rest.database;

import org.flysoohigh.rest.model.Message;
import org.flysoohigh.rest.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 24.12.2018.
 */
public class DatabaseStub {
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();

    static {
        messages.put(1L, new Message(1L, "Message #1", "Alex"));
        messages.put(2L, new Message(2L, "Message #2", "Ivan"));
        messages.put(3L, new Message(3L, "Message #3", "Ant"));
        messages.put(4L, new Message(4L, "Message #4", "Serg"));
        profiles.put("Alex", new Profile(1L, "Alex", "Alexander", "Alexander"));
        profiles.put("Serg", new Profile(2L, "Serg", "Sergey", "Sergey"));
    }

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}
