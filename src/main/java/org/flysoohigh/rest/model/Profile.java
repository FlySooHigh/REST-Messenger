package org.flysoohigh.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

/**
 * Created on 24.12.2018.
 */
@XmlRootElement
public class Profile {
    private Long id;
    private String profileName;
    private String firstName;
    private String lastName;
    private LocalDateTime created;

    public Profile() {
    }

    public Profile(Long id, String profileName, String firstName, String lastName) {
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = LocalDateTime.now().withNano(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
