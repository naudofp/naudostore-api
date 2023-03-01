package com.naudo.service.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.naudo.dto.order.OrderDTO;
import com.naudo.dto.orderitem.OrderItemDTO;
import com.naudo.enums.OrderStatus;
import com.naudo.exception.ProductNotFoundException;
import com.naudo.model.order.Order;
import com.naudo.model.orderitem.OrderItem;
import com.naudo.model.product.Product;
import com.naudo.repository.order.OrderRepository;
import com.naudo.repository.orderitem.OrderItemRepository;
import com.naudo.repository.product.ProductRepository;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@Service
public class OrderServiceImpl implements OrderService{

	private final OrderRepository orderRepository;
	private final OrderItemRepository itemRepository;
	private final ProductRepository productRepository;
	
	public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository itemRepository, ProductRepository productRepository) {
		this.orderRepository = orderRepository;
		this.itemRepository = itemRepository;
		this.productRepository = productRepository;
	}

	@Override
	public Order save(OrderDTO dto) {

		List<OrderItem> itemsEntity = new ArrayList<>();
		Order order = new Order(UUID.randomUUID(), LocalDateTime.now(), OrderStatus.WAITING_TO_PAYMENT, null);

		for (OrderItemDTO itemDTO : dto.items()) {
			Product product = productRepository.findById(itemDTO.idProduct()).orElseThrow(() -> new ProductNotFoundException("Product " + itemDTO.idProduct() + " was not found"));
			itemsEntity.add(new OrderItem(UUID.randomUUID(), product, itemDTO.quantity(), order));
		}
		
		order.getItems().addAll(itemsEntity);
		Order orderSaved = orderRepository.save(order);

		return null;
	}

	@Override
	public void delete(UUID id) {
	}

}