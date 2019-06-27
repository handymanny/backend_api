package Exception;

public class UserFieldRequiredException extends RuntimeException {
    public UserFieldRequiredException() {
        super("The field(s) are/is required");
    }
}
