package Exception;

public class UserInvalidCreditCardException extends RuntimeException {
    public UserInvalidCreditCardException() {
        super("This is an invalid Credit Card");
    }
}
