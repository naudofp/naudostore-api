package com.naudo.service.order;

import java.util.UUID;

import com.naudo.dto.order.OrderDTO;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public interface OrderService {

	OrderDTO save(OrderDTO dto);
	
	void delete(UUID id);
}
