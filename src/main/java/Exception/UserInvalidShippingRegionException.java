package Exception;

public class UserInvalidShippingRegionException extends RuntimeException {
    public UserInvalidShippingRegionException() {
        super("The Shipping Region ID is not a number");
    }
}
