package com.naudo.dto.product;

import java.util.UUID;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public record ProductSaveDTO(
		UUID id,
		String name, 
		String description, 
		Double price
	) {

}
