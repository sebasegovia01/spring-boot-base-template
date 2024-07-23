package com.br.base_template.exception;

import com.br.base_template.common.RespStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;



import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        CanonicalError canonicalError = new CanonicalError();
        canonicalError.setCode("VALIDATION_ERROR");
        canonicalError.setType(ErrorType.NEG);
        canonicalError.setDescription("Validation failed for one or more fields");

        SourceError sourceError = new SourceError();
        sourceError.setCode(String.valueOf(HttpStatus.BAD_REQUEST));
        sourceError.setDescription(errors.toString());
        SourceError.ErrorSourceDetails errorSourceDetails = new SourceError.ErrorSourceDetails();
        errorSourceDetails.setSource(ErrorSource.API);
        sourceError.setErrorSourceDetails(errorSourceDetails);

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(RespStatus.ERROR);
        errorResponse.setCanonicalError(canonicalError);
        errorResponse.setSourceError(sourceError);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        CanonicalError canonicalError = new CanonicalError();
        canonicalError.setCode("NOT_FOUND");
        canonicalError.setType(ErrorType.NEG);
        canonicalError.setDescription("The requested resource was not found");

        SourceError sourceError = new SourceError();
        sourceError.setCode("404");
        sourceError.setDescription("The requested URL " + ex.getRequestURL() + " was not found on this server.");
        SourceError.ErrorSourceDetails errorSourceDetails = new SourceError.ErrorSourceDetails();
        errorSourceDetails.setSource(ErrorSource.API);
        sourceError.setErrorSourceDetails(errorSourceDetails);

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(RespStatus.ERROR);
        errorResponse.setCanonicalError(canonicalError);
        errorResponse.setSourceError(sourceError);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllUncaughtException(Exception ex) {
        CanonicalError canonicalError = new CanonicalError();
        canonicalError.setCode("INTERNAL_SERVER_ERROR");
        canonicalError.setType(ErrorType.TEC);
        canonicalError.setDescription("An unexpected error occurred");

        SourceError sourceError = new SourceError();
        sourceError.setCode("500");
        sourceError.setDescription(ex.getMessage());
        SourceError.ErrorSourceDetails errorSourceDetails = new SourceError.ErrorSourceDetails();
        errorSourceDetails.setSource(ErrorSource.API);
        sourceError.setErrorSourceDetails(errorSourceDetails);

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(RespStatus.ERROR);
        errorResponse.setCanonicalError(canonicalError);
        errorResponse.setSourceError(sourceError);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
