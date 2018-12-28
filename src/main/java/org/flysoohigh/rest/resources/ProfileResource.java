package org.flysoohigh.rest.resources;

import org.flysoohigh.rest.model.Profile;
import org.flysoohigh.rest.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

/**
 * Created on 26.12.2018.
 */

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

    private ProfileService profileService = new ProfileService();

    @GET
    public List<Profile> getProfiles() {
        return profileService.getAllProfiles();
    }

    @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName) {
        return profileService.getProfile(profileName);
    }

    @POST
    public Response addProfile(Profile profile, @Context UriInfo uriInfo) {
        Profile newProfile = profileService.addProfile(profile);
        String newProfileId = String.valueOf(newProfile.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newProfileId).build();
        return Response.created(uri)
                       .entity(newProfile)
                       .build();
    }

    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
        profile.setProfileName(profileName);
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
    public void deleteProfile(@PathParam("profileName") String profileName) {
        profileService.removeProfile(profileName);
    }
}
