package com.naudo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/payment")
public class StripePaymentController {

	@Value("${stripe.apikey}")
	private String stripeApiKey;
	
	 @PostMapping("/charge")
	 public ResponseEntity<Boolean> chargeCard(@RequestParam("stripeToken") String stripeToken, @RequestParam("amount") double amount) {
		Stripe.apiKey = stripeApiKey;

        try {
            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", (int) (amount * 100));
            chargeParams.put("currency", "usd");
            chargeParams.put("source", stripeToken);

            Charge charge = Charge.create(chargeParams);

            if (charge.getPaid()) {
                // pagamento processado com sucesso
                return ResponseEntity.status(HttpStatus.OK).body(true);
            } else {
                // pagamento não foi processado
                return ResponseEntity.status(HttpStatus.OK).body(false);
            }

        } catch (StripeException e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }

    }
}
