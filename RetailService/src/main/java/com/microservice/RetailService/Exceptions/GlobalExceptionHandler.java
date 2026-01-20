package com.microservice.RetailService.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<String> handleInvalidRequest(InvalidRequestException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());

	}

	@ExceptionHandler(HandlerMethodValidationException.class)
	public ResponseEntity<Map<String, String>> HandlerMethodValidationException(HandlerMethodValidationException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getAllValidationResults().forEach(result -> {
			result.getResolvableErrors().forEach(error -> {
				errors.put(result.getMethodParameter().getParameterName(), error.getDefaultMessage());
			});
		});

		return ResponseEntity.badRequest().body(errors);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentException(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errors);

	}

	// Fallback
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return ResponseEntity.status(400).body("Internal Server Error");

	}

}
