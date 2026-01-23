package io.hiusnef.devsphere.error;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleGlobalException(
                        Exception ex, WebRequest request) {

                ErrorResponse errorResponse = new ErrorResponse(
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                "An unexpected error occurred",
                                request);

                log.error("Exception: {}", ex.getMessage(), ex);
                return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(BusinessError.class)
        public ResponseEntity<ErrorResponse> handleBusinessError(
                        BusinessError ex, WebRequest request) {
                ErrorResponse errorResponse = new ErrorResponse(
                                ex.getStatus().value(),
                                ex.getMessage(),
                                request);

                log.error("BusinessError: {}", errorResponse.getMessage());
                return new ResponseEntity<>(errorResponse, ex.getStatus());
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorResponse> handleValidationExceptions(
                        MethodArgumentNotValidException ex, WebRequest request) {

                Map<String, String> errors = new HashMap<>();
                ex.getBindingResult().getFieldErrors()
                                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(),
                                request);

                log.error("MethodArgumentNotValidException: {}", errorResponse.getMessage());
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<ErrorResponse> handleException(ConstraintViolationException exception,
                        WebRequest request) {
                String code = Optional.ofNullable(exception.getConstraintViolations())
                                .flatMap(cv -> cv.stream().map(v -> v.getMessage() + "." + v.getPropertyPath())
                                                .filter(Objects::nonNull)
                                                .findFirst())
                                .orElse("Constraint violation error");

                log.error("ConstraintViolationException: {}", exception.getMessage());
                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), code, request);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        @ExceptionHandler(NoResourceFoundException.class)
        public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
                        NoResourceFoundException ex, WebRequest request) {

                ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request);

                log.warn("Resource not found: {}", ex.getMessage());
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
}