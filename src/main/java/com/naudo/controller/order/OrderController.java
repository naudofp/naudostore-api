package com.naudo.controller.order;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naudo.dto.order.OrderDTO;
import com.naudo.model.order.Order;
import com.naudo.service.order.OrderService;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@RestController
@CrossOrigin(maxAge = 3200, origins = "*")
@RequestMapping("/api/order")
public class OrderController {

	private final OrderService service;
	
	public OrderController(OrderService service) {
		this.service = service;
	}

	@PostMapping()
	public ResponseEntity<OrderDTO> save(@RequestBody OrderDTO dto){
		return ResponseEntity.status(HttpStatus.OK).body(service.save(dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOne(@PathVariable("id") String id){
		service.delete(UUID.fromString(id));
		return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully");
	}
}
