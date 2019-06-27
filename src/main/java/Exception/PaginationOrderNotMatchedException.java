package Exception;

public class PaginationOrderNotMatchedException extends RuntimeException {
    public PaginationOrderNotMatchedException() {
        super("The order is not matched 'field,(DESC|ASC)'");
    }
}
