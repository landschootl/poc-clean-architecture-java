package claranet.cdp.application.entities;

import org.springframework.http.HttpStatus;

/**
 * Object that represents a domain error
 */
public class DomainError {

    protected final HttpStatus code;
    protected final String message;

    public DomainError(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
