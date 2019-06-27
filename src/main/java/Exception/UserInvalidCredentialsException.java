package Exception;

public class UserInvalidCredentialsException extends RuntimeException {
    public UserInvalidCredentialsException() {
        super("Email or Password is invalid");
    }
}
