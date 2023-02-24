package com.naudo.repository.orderitem;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naudo.model.orderitem.OrderItem;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, UUID>{

}
