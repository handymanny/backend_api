package Exception;

public class UserInvalidPhoneException extends RuntimeException {
    public UserInvalidPhoneException() {
        super("This is an invalid phone number");
    }
}
