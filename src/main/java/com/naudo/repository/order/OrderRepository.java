package com.naudo.repository.order;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naudo.model.order.Order;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID>{

}
