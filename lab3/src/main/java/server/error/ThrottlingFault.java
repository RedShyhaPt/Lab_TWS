package server.error;

public class ThrottlingFault {
    private static final String DEFAULT_MESSAGE = "Not allowed to execute more than 1 time for this request";
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
