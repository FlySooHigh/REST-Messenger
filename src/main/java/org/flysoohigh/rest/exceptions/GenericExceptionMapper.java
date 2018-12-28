package org.flysoohigh.rest.exceptions;

import org.flysoohigh.rest.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created on 28.12.2018.
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "yandex.ru");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity(errorMessage)
                       .build();
    }
}
