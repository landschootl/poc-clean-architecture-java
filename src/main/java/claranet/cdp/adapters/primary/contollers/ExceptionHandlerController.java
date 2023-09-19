package claranet.cdp.adapters.primary.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Controller which allows manages API exceptions
 */
@RestControllerAdvice
public class ExceptionHandlerController {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @ExceptionHandler(DomainErrorException.class)
    public ResponseEntity<ExceptionMessage> domainErrorExceptionHandler(HttpServletRequest request, DomainErrorException exception) {
        ExceptionMessage message = new ExceptionMessage()
                .setDate(LocalDateTime.now().format(formatter))
                .setPath(request.getRequestURI() + "?" + request.getQueryString())
                .setClassName(exception.getClass().getName())
                .setMessage(exception.getMessage());
        return new ResponseEntity<>(message, exception.getDomainError().getCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionMessage> genericExceptionHandler(HttpServletRequest request, Exception exception) {
        ExceptionMessage message = new ExceptionMessage()
                .setDate(LocalDateTime.now().format(formatter))
                .setPath(request.getRequestURI() + "?" + request.getQueryString())
                .setClassName(exception.getClass().getName())
                .setMessage(exception.getMessage());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}