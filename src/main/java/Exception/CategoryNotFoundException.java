package Exception;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException() {
        super("Don't exist category with this ID");
    }
}
