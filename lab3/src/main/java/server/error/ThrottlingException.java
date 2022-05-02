package server.error;

import javax.xml.ws.WebFault;

@WebFault(faultBean = "server.error.ThrottlingFault")
public class ThrottlingException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final ThrottlingFault fault;
    public ThrottlingException(String message, ThrottlingFault fault) {
        super(message);
        this.fault = fault;
    }
    public ThrottlingException(String message, ThrottlingFault fault,
                                    Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }
}
