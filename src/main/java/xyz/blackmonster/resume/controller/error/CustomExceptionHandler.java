package xyz.blackmonster.resume.controller.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import xyz.blackmonster.resume.json.v1.common.ErrorMessage;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = { IllegalStateException.class })
    public ResponseEntity<ErrorMessage> handleIllegalStateException(Exception ex, WebRequest request) {
        ErrorMessage failure = new ErrorMessage(ex.getMessage());
        LOGGER.error("API request is causing illegal state.", ex);
        return new ResponseEntity<>(failure, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { AuthenticationException.class })
    public ResponseEntity<ErrorMessage> handleAuthenticationException(Exception ex, WebRequest request) {
        ErrorMessage failure = new ErrorMessage(ex.getMessage());
        LOGGER.error("Not authorized to make the call.", ex);
        return new ResponseEntity<>(failure, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ErrorMessage> handleAnyException(Exception ex, WebRequest request) {
        ErrorMessage failure = new ErrorMessage(ex.getMessage());
        LOGGER.error("Error has been caught.", ex);
        return new ResponseEntity<>(failure, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
