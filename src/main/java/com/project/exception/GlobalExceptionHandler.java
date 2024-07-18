package com.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Controller
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	

    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserException(AdminNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleCustomerException(AppointmentNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

       @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleCategoryException(CartNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(ContactInfoNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleOrderException(ContactInfoNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(DayCareBookingsNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleCartException(DayCareBookingsNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleAddressException(PaymentNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(PetsNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleFeedbackException(PetsNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePaymentException(ProductNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(UsersNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleAdminException(UsersNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGlobalException(Exception ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
    }
    


}
