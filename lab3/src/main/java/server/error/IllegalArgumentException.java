package server.error;
import javax.xml.ws.WebFault;

@WebFault(faultBean = "server.error.ClientServiceFault")
public class IllegalArgumentException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    private final ClientServiceFault fault;
    public IllegalArgumentException(String message, ClientServiceFault fault)
    {
        super(message);
        this.fault = fault;
    }
    public IllegalArgumentException(String message, ClientServiceFault fault,
                                Throwable cause) {
        super(message, cause);
        this.fault = fault;
    }

    public ClientServiceFault getFaultInfo() {
        return fault;
    }
}