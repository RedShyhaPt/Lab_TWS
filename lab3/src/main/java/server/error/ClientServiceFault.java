package server.error;

public class ClientServiceFault {
    private static final String DEFAULT_MESSAGE = "It cannot be null or empty";
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ClientServiceFault defaultInstance() {
        ClientServiceFault fault = new ClientServiceFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
