package com.naudo.repository.product;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naudo.model.product.Product;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>{
}
