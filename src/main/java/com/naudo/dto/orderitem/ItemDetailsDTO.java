package com.naudo.dto.orderitem;

import java.util.UUID;

import com.naudo.dto.product.ProductCardDTO;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public record ItemDetailsDTO(
		
			UUID id,
			ProductCardDTO product,
			Integer quantity
		) {}
