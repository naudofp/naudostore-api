package com.naudo.exception;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public class ImageByteUnvalidException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ImageByteUnvalidException(String message) {
		super(message);
	}

}
