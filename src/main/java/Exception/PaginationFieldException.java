package Exception;

public class PaginationFieldException extends RuntimeException {
    public PaginationFieldException() {
        super("The field of order is not allow sorting");
    }
}
