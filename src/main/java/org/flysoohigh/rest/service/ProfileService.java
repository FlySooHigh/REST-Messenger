package org.flysoohigh.rest.service;

import org.flysoohigh.rest.database.DatabaseStub;
import org.flysoohigh.rest.model.Profile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created on 26.12.2018.
 */
public class ProfileService {
    private Map<String, Profile> profiles = DatabaseStub.getProfiles();
    private final static int maxProfileId = DatabaseStub.getProfiles().size();

    public ProfileService() {
    }

    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    public Profile addProfile(Profile profile) {
        profile.setId(maxProfileId + 1L);
        profile.setCreated(LocalDateTime.now().withNano(0));
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile getProfile(String profileName) {
        return profiles.get(profileName);
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getProfileName().isEmpty()) {
            return null;
        }
        profile.setCreated(LocalDateTime.now().withNano(0));
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
    }
}
