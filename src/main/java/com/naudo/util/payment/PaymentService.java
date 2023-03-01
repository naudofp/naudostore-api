package com.naudo.util.payment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.naudo.exception.ItsNoPaidException;
import com.stripe.Stripe;
import com.stripe.model.Charge;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@Service
public class PaymentService {

	@Value("${stripe.apikey}")
	private String stripeApiKey;

	public PaymentService() {
		
	}
	
	public void chargeCard(String stripeToken, double amount) throws Exception {
		Stripe.apiKey = stripeApiKey;
		
		try {
            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", (int) (amount * 100));
            chargeParams.put("currency", "usd");
            chargeParams.put("source", stripeToken);

            Charge charge = Charge.create(chargeParams);
            
            if(!charge.getPaid()) {
            	throw new ItsNoPaidException("Product was not paid");
            }
		} catch (Exception e) {
			throw e;
		}
	}
	
	
}
