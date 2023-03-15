package com.naudo.dto.order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.naudo.dto.orderitem.ItemDetailsDTO;
import com.naudo.enums.OrderStatus;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public record OrderDetailsDTO(
			
			UUID id,
			Double amount,
			LocalDateTime issueDate,
			OrderStatus status,
			List<ItemDetailsDTO> items
		) {}
