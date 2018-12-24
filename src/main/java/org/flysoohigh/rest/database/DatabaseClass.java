package org.flysoohigh.rest.database;

import org.flysoohigh.rest.model.Message;
import org.flysoohigh.rest.model.Profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 24.12.2018.
 */
public class DatabaseClass {
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<Long, Profile> profiles = new HashMap<>();

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<Long, Profile> getProfiles() {
        return profiles;
    }
}
