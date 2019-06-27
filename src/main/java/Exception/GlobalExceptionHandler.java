package Exception;

import Model.ErrorTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Create our headers
    private HttpHeaders httpHeaders = generateHeaders();

    // Exception Handling
    // Authorization Exceptions
    @ExceptionHandler(AuthorizationCodeNotFound.class)
    public ResponseEntity handleAuthorizationCodeNotFound() {

        // Create our error template
        ErrorTemplate error = ExceptionConstants.AUT_ONE;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }

    @ExceptionHandler(AuthorizationNotAuthorized.class)
    public ResponseEntity handleAuthorizationNotAuthorized() {

        // Create our error template
        ErrorTemplate error = ExceptionConstants.AUT_TWO;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }


    // Pagination Exceptions
    @ExceptionHandler(PaginationOrderNotMatchedException.class)
    public ResponseEntity handlePaginationOrderNotMatch() {
        // Create our error template
        ErrorTemplate error = ExceptionConstants.PAG_ONE;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }

    @ExceptionHandler(PaginationFieldException.class)
    public ResponseEntity handlePaginationFieldException() {
        // Create our error template
        ErrorTemplate error = ExceptionConstants.PAG_TWO;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }


    // User Exceptions
    @ExceptionHandler(UserInvalidCredentialsException.class)
    public ResponseEntity handleInvalidCredentials() {
        // Create our error template
        ErrorTemplate error = ExceptionConstants.USR_ONE;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }

    @ExceptionHandler(UserFieldRequiredException.class)
    public ResponseEntity handleFieldRequired() {
        // Create our error template
        ErrorTemplate error = ExceptionConstants.USR_TWO;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }

    @ExceptionHandler(UserEmailInvalidException.class)
    public ResponseEntity handlerInvalidEmail() {
        // Create our error template
        ErrorTemplate error = ExceptionConstants.USR_THREE;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }

    @ExceptionHandler(UserEmailExistException.class)
    public ResponseEntity handlerEmailExist() {
        // Create our error template
        ErrorTemplate error = ExceptionConstants.USR_FOUR;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }

    @ExceptionHandler(UserEmailNotFoundException.class)
    public ResponseEntity handleEmailNotFound() {
        // Create our error template
        ErrorTemplate error = ExceptionConstants.USR_FIVE;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }

    @ExceptionHandler(UserInvalidPhoneException.class)
    public ResponseEntity handleInvalidPhone() {
        // Create our error template
        ErrorTemplate error = ExceptionConstants.USR_SIX;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }

    @ExceptionHandler(UserFieldTooLongException.class)
    public ResponseEntity handleFieldTooLong() {
        // Create our error template
        ErrorTemplate error = ExceptionConstants.USR_SEVEN;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }

    @ExceptionHandler(UserInvalidCreditCardException.class)
    public ResponseEntity handleInvalidCreditCard() {
        // Create our error template
        ErrorTemplate error = ExceptionConstants.USR_EIGHT;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }

    @ExceptionHandler(UserInvalidShippingRegionException.class)
    public ResponseEntity handleInvalidShippingRegion() {
        // Create our error template
        ErrorTemplate error = ExceptionConstants.USR_NINE;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }


    // Category Exceptions
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity handleCategoryNotFound() {

        // Create our error template
        ErrorTemplate error = ExceptionConstants.CAT_ONE;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }

    // Department Exceptions
    @ExceptionHandler(DepartmentNotNumberException.class)
    public ResponseEntity handleDepartmentNotNumber() {

        // Create our error template
        ErrorTemplate error = ExceptionConstants.DEP_ONE;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity handleDepartmentNotFound() {

        // Create our error template
        ErrorTemplate error = ExceptionConstants.DEP_TWO;

        // Return our error code
        return new ResponseEntity<>(buildError(error), httpHeaders, error.getStatus());
    }


    // Type mismatch ( eg, when we receive a string when we want an integer )
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity handleTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {

        // Get request of exception
        String errorUri = ((ServletWebRequest)request).getRequest().getRequestURL().toString();

        if (errorUri.startsWith("http://localhost:8080/departments/")) {
            return handleDepartmentNotNumber();
        }

        if (errorUri.startsWith("http://localhost:8080/categories/")) {
            return handleCategoryNotFound();
        }

        return null;
    }




    // Helper methods
    private String buildError(ErrorTemplate error) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.createObjectNode();
        JsonNode errorNode = mapper.createObjectNode();

        ((ObjectNode) errorNode).put("status", error.getStatus().value());
        ((ObjectNode) errorNode).put("code", error.getCode());
        ((ObjectNode) errorNode).put("message", error.getMessage());
        ((ObjectNode) errorNode).put("field", error.getField());

        ((ObjectNode) root).set("error", errorNode);

        try {
            return mapper.writeValueAsString(root);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private HttpHeaders generateHeaders () {
        httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return httpHeaders;
    }
}
