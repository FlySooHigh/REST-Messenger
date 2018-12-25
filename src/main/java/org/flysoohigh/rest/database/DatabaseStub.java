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
    private static Map<Long, Profile> profiles = new HashMap<>();

    static {
        messages.put(1L, new Message(1L, "Message #1", "Alex"));
        messages.put(2L, new Message(2L, "Message #2", "Alex"));
    }

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<Long, Profile> getProfiles() {
        return profiles;
    }
}
