package com.naudo.exception;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public class OrderNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
