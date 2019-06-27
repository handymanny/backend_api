package Exception;

public class UserEmailExistException extends RuntimeException {
    public UserEmailExistException() {
        super("The email already exists");
    }
}
