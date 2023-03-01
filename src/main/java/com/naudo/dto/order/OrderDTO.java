package com.naudo.dto.order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.naudo.dto.orderitem.OrderItemDTO;
import com.naudo.enums.OrderStatus;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public record OrderDTO(
		
		UUID id,
		LocalDateTime issueDate,
		OrderStatus status,
		List<OrderItemDTO> items,
		Double amount
		) {

}
