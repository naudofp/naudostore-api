package com.naudo.model.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.naudo.enums.OrderStatus;
import com.naudo.model.orderitem.OrderItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@Entity
@Table(name = "tb_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_order")
	private UUID id;
	@Column(name = "issue_date_order")
	private LocalDateTime issueDate;
	@Column(name = "status_order")
	private OrderStatus status;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> items;
	@Transient
	private Double amount;
	
	public Order(UUID id, LocalDateTime issueDate, OrderStatus status, Double amount) {
		this.id = id;
		this.issueDate = issueDate;
		this.status = status;
		this.amount = amount;
		this.items = new ArrayList<>();
	}
	
	public Order() {}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public Double getAmount() {
		
		for (OrderItem i : items) {
			amount += i.getAmount();
		}
		return amount;
	}
}
