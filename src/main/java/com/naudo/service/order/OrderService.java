package com.naudo.service.order;

import java.util.UUID;

import com.naudo.dto.order.OrderDTO;
import com.naudo.model.order.Order;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public interface OrderService {

	Order save(OrderDTO dto);
	
	void delete(UUID id);
}
