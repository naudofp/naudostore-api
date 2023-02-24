package com.naudo.projection.product;

import java.util.UUID;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public interface ProductProjection {

	UUID getId();
	
	String name();
	
	String getDescription();
	
	byte[] getImage();
}
