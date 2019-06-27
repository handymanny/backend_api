package Exception;

public class AuthorizationCodeNotFound extends RuntimeException {
    public AuthorizationCodeNotFound() {
        super("Authorization code is empty");
    }
}
