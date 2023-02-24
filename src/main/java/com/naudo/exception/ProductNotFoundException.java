package com.naudo.exception;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public class ProductNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String message) {
		super(message);
	}
}
