package server.error;

public class ThrottlingFault {
    private static final String DEFAULT_MESSAGE = "It cannot be null or empty";
    protected String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ThrottlingFault defaultInstance() {
        ThrottlingFault fault = new ThrottlingFault();
        fault.message = DEFAULT_MESSAGE;
        return fault;
    }
}
