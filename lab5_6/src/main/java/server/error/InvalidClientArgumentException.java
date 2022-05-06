package server.error;

public class InvalidClientArgumentException extends Exception {
    private static final long serialVersionUID = -6647544772732631047L;
    public static InvalidClientArgumentException DEFAULT_INSTANCE = new
            InvalidClientArgumentException("Argument cannot be null, empty or less than 0");
    public InvalidClientArgumentException(String message) {
        super(message);
    }
}
