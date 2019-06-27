package Exception;

public class DepartmentNotNumberException extends RuntimeException {

    public DepartmentNotNumberException() {
        super("The ID is not a number");
    }
}
