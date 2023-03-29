package com.naudo.util.payment;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.naudo.enums.OrderStatus;
import com.naudo.exception.ItsNoPaidException;
import com.naudo.exception.OrderNotFoundException;
import com.naudo.model.order.Order;
import com.naudo.repository.order.OrderRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@Service
public class PaymentService {

	@Value("${stripe.apikey}")
	private String stripeApiKey;
	
	private OrderRepository orderRepository;

	public PaymentService(OrderRepository repository) {
		this.orderRepository = repository;
	}
	
	public void chargeCard(String stripeToken, UUID orderId) throws Exception {
		Stripe.apiKey = stripeApiKey;
		
		try {
			Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order " + orderId + " was not found"));
			
			Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", (int) (order.getAmount() * 100));
            chargeParams.put("currency", "brl");
            chargeParams.put("source", stripeToken);

            Charge charge = Charge.create(chargeParams);
            
            if(!charge.getPaid()) {
            	throw new ItsNoPaidException("Order was not paid");
            }
            
            order.setStatus(OrderStatus.PAID);
            orderRepository.save(order);
            
		} catch (Exception e) {
			throw e;
		}
	}
	
	public String pixPayment(UUID orderId) throws StripeException {
		Stripe.apiKey = stripeApiKey;
		
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order " + orderId + " was not found"));
		try {
			PaymentIntentCreateParams createParams = PaymentIntentCreateParams.builder()
			  .setAmount(Long.parseLong(order.getAmount().toString()))
			  .setCurrency("brl")
			  .setPaymentMethod("pix")
			  .build();
	
			
			PaymentIntent paymentIntent = PaymentIntent.create(createParams);
			return paymentIntent.toJson();
			
		} catch (StripeException e) {
			throw e;
		}
	}
	
	
}
