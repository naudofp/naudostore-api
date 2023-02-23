package com.naudo.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@Entity
@Table(name = "tb_orderitem")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_orderitem")
	private UUID id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product")
	private Product product;
	@Column(name = "quantity_product")
	private Integer quantity;
	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_order")
	private Order order;

	public OrderItem(UUID id, Product product, Integer quantity, Order order) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.order = order;
	}
	
	public Double getAmount() {
		return product.getPrice() * quantity;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
