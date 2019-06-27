package Exception;

public class UserFieldTooLongException extends RuntimeException {
    public UserFieldTooLongException(String fieldName) {
        super(String.format("This is too long <%s>", fieldName));
    }
}
