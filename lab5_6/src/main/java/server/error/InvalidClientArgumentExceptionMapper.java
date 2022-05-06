package server.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidClientArgumentExceptionMapper implements
        ExceptionMapper<InvalidClientArgumentException> {

    @Override
    public Response toResponse(InvalidClientArgumentException e) {
        return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
