package Exception;

import Model.ErrorTemplate;
import org.springframework.http.HttpStatus;

public class ExceptionConstants {

    // All errors except few have bad request, re use one variables
    private static HttpStatus status = HttpStatus.BAD_REQUEST;

    // Authorization
    public static ErrorTemplate AUT_ONE = new ErrorTemplate(status, "AUT_01", "Authorization code is empty", "authorization");
    public static ErrorTemplate AUT_TWO = new ErrorTemplate(status, "AUT_01", "Access Unauthorized", "authorization");

    // Pagination
    public static ErrorTemplate PAG_ONE = new ErrorTemplate(status, "PAG_01", "The order is not matched 'field,(DESC|ASC)'", "");
    public static ErrorTemplate PAG_TWO = new ErrorTemplate(status, "PAG_02", "The field of order is not allow sorting", "");

    // User
    public static ErrorTemplate USR_ONE = new ErrorTemplate(status, "USR_01", "Email or Password is invalid", "email / password");
    public static ErrorTemplate USR_TWO = new ErrorTemplate(status, "USR_02", "The field(s) are/is required", "");
    public static ErrorTemplate USR_THREE = new ErrorTemplate(status, "USR_03", "The email is invalid", "email");
    public static ErrorTemplate USR_FOUR = new ErrorTemplate(status, "USR_04", "The email already exists", "email");
    public static ErrorTemplate USR_FIVE = new ErrorTemplate(status, "USR_05", "The email doesn't exist", "email");
    public static ErrorTemplate USR_SIX = new ErrorTemplate(status, "USR_06", "this is an invalid phone number", "phone");
    public static ErrorTemplate USR_SEVEN = new ErrorTemplate(status, "USR_07", "this is too long ", "");
    public static ErrorTemplate USR_EIGHT = new ErrorTemplate(status, "USR_08", "this is an invalid Credit Card", "credit_card");
    public static ErrorTemplate USR_NINE = new ErrorTemplate(status, "USR_09", "The Shipping Region ID is not number", "shipping_region_id");

    // Category
    public static ErrorTemplate CAT_ONE = new ErrorTemplate(status, "CAT_01", "Don't exist category with this ID", "category_id");

    // Department
    public static ErrorTemplate DEP_ONE = new ErrorTemplate(status, "DEP_01", "The ID is not a number", "department_id");
    public static ErrorTemplate DEP_TWO = new ErrorTemplate(status, "DEP_02", "Don'exist department with this ID", "department_id");

}
