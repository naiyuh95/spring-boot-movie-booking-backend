package com.booking.ny.error;

import org.hibernate.exception.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;



import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	



	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllException(Exception ex){


    	return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex), ex);
    }
	


    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        if (ex.getCause() instanceof ConstraintViolationException) {

            return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, "Database error", ex), ex);
        }

        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex), ex);
    }

    /**
     * Handle seat not available for pending exception
     */
    @ExceptionHandler({ SeatsNotAvailableException.class })
    public ResponseEntity<?> customSeatsNotAvailable(Exception ex) {

    	return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex), ex);
    }

    /**
     * Handle customer details missing for confirming booking
     */
    @ExceptionHandler({ MissingCustomerError.class })
    public ResponseEntity<?> customMissingCustomerError(Exception ex) {

    	return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex), ex);
    }
    

    private static ResponseEntity<Object> buildResponseEntity(ApiError apiError, Exception ex) {

        return new ResponseEntity<>(apiError, apiError.getStatus());
    }


}