package com.brunobr9.cursomc.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brunobr9.cursomc.exceptions.AuthorizationException;

@ControllerAdvice
public class ResourceExceptionHandler {
//extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(ObjectNotFoundException.class)
//    public ResponseEntity<Object> handleObjectNotFoundException(ObjectNotFoundException ex, HttpHeaders headers,
//	    WebRequest request) {
//
//	StandardError standardError = new StandardError(ex.getMessage(), System.currentTimeMillis());
//
//	return handleExceptionInternal(ex, standardError, headers, HttpStatus.NOT_FOUND, request);
//    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> handleObjectNotFoundException(ObjectNotFoundException ex,
	    HttpServletRequest request) {
	StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage(),
		System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<StandardError> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
	    HttpServletRequest request) {
	StandardError standardError = new StandardError(HttpStatus.BAD_REQUEST.value(), ex.getMessage(),
		System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<StandardError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
	    HttpServletRequest request) {
	ValidationError validationError = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação",
		System.currentTimeMillis());

	for (FieldError f : ex.getBindingResult().getFieldErrors()) {
	    validationError.addError(f.getField(), f.getDefaultMessage());
	}

	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<StandardError> handleObjectNotFoundException(AuthorizationException ex,
	    HttpServletRequest request) {
	StandardError standardError = new StandardError(HttpStatus.FORBIDDEN.value(), ex.getMessage(),
		System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

}
