package org.flysoohigh.rest.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created on 26.12.2018.
 */

@Path("/paramDemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class ParamResource {

    @GET
    @Path("/annotations")
    public String annotationsDemoMethod(@MatrixParam("matrix") String matrixValue,
                                        @HeaderParam("header") String headerValue,
                                        @CookieParam("cookie") String cookieValue) {
        return "Matrix param value: " + matrixValue + "\n"
                + "Header param value: " + headerValue + "\n"
                + "Cookie: " + cookieValue;
    }

    @GET
    @Path("/context")
    public String contextDemoMethod(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        String absolutePath = uriInfo.getAbsolutePath().toString();
        String cookies = httpHeaders.getCookies().toString();
        return "absolutePath: " + absolutePath + "\n"
                + "cookies: " + cookies;
    }

}
