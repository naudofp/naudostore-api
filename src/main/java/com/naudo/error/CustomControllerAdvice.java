package com.naudo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.naudo.exception.ImageByteUnvalidException;
import com.naudo.exception.ProductNotFoundException;

public class CustomControllerAdvice {

	 // PRODUCT
	 
	 @ExceptionHandler(ProductNotFoundException.class)
	 public ResponseEntity<ErrorResponse> handleProductNotFoundException(Exception exception) {
		 return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
	 }
	
	 @ExceptionHandler(ImageByteUnvalidException.class)
	 public ResponseEntity<ErrorResponse> handleImageByteUnvalidException(Exception exception) {
		 return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(HttpStatus.CONFLICT, exception.getMessage()));
	 }

}
