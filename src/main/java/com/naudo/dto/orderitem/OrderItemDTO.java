package com.naudo.dto.orderitem;

import java.util.UUID;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public record OrderItemDTO(
		
		UUID idProduct,
		Integer quantity
		) {

}
