package Exception;

public class UserEmailNotFoundException extends RuntimeException {
    public UserEmailNotFoundException() {
        super("The email doesn't exist");
    }
}
