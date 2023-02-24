package com.naudo.model.product;

import java.util.UUID;

import org.hibernate.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@Entity
@Table(name = "tb_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID) 
	@Column(name = "id_product")
	private UUID id;
	@Column(name = "name_product")
	private String name;
	@Column(name = "description_product")
	private String description;
	@Column(name = "price_product")
	private Double price;
	@Lob
	@Column(name = "image_product", length = Length.LOB_DEFAULT)
	private byte[] image;
	
	public Product() {}

	public Product(UUID id, String name, String description, Double price, byte[] image) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
