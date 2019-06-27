package Exception;

public class AuthorizationNotAuthorized extends RuntimeException {
    public AuthorizationNotAuthorized() {
        super("Access Unauthorized");
    }
}
