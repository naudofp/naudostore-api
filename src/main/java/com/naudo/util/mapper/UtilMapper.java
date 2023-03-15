package com.naudo.util.mapper;

import java.util.ArrayList;
import java.util.List;

import com.naudo.dto.order.OrderDTO;
import com.naudo.dto.orderitem.ItemDetailsDTO;
import com.naudo.dto.orderitem.OrderItemDTO;
import com.naudo.dto.product.ProductCardDTO;
import com.naudo.model.order.Order;
import com.naudo.model.orderitem.OrderItem;
import com.naudo.model.product.Product;
import com.naudo.service.image.ImageService;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

public class UtilMapper {
	
	public static ProductCardDTO eProductToProductCardDTO(Product product) {
		return new ProductCardDTO(product.getId(), product.getName(), product.getDescription(), ImageService.getImageBase64(product.getImage()), product.getPrice());
	}
	
	public static List<ProductCardDTO> eAllProductsToAllProductCardDTO(List<Product> products) {
		List<ProductCardDTO> productDtos = new ArrayList<>();
		products.forEach(product -> productDtos.add(eProductToProductCardDTO(product)));
		
		return productDtos;
	}
	
	public static List<ItemDetailsDTO> eAllOrderItemsToAllItemDetailsDTO(List<OrderItem> items){
		List<ItemDetailsDTO> itemsDto = new ArrayList<>();
		items.forEach(item -> itemsDto.add(new ItemDetailsDTO(item.getId(), eProductToProductCardDTO(item.getProduct()), item.getQuantity())));
		
		return itemsDto;
	}
	
	public static List<OrderItemDTO> eAllOrderItemsToAllOrderItemDTO(List<OrderItem> items){
		List<OrderItemDTO> itemsDto = new ArrayList<>();
		items.forEach(item -> itemsDto.add(new OrderItemDTO(item.getProduct().getId(), item.getQuantity())));
		return itemsDto;
	}
	
	public static OrderDTO eOrderToOrderDTO(Order entity) {
		return new OrderDTO(entity.getId(), entity.getIssueDate(), entity.getStatus(), eAllOrderItemsToAllOrderItemDTO(entity.getItems()), entity.getAmount());
	}
	
	public static List<OrderDTO> eAllOrderToAllOrderDTO(List<Order> orders) {
		List<OrderDTO> ordersDto = new ArrayList<>();
		orders.forEach(item -> ordersDto.add(eOrderToOrderDTO(item)));
		return ordersDto;
	}
}
