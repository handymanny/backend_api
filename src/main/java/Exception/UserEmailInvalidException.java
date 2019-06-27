package Exception;

public class UserEmailInvalidException extends RuntimeException {
    public UserEmailInvalidException() {
        super("The email is invalid");
    }
}
