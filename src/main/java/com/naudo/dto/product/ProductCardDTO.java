package com.naudo.dto.product;

import java.util.UUID;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public record ProductCardDTO(
		
		UUID id,
		String name,
		String description,
		String imageBase64,
		Double price
		) {

}
