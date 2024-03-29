package com.naudo.util.payment;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author Fellipe Naudo  
 * @github naudofp
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/payment")
public class PaymentController {

	private final PaymentService service;
	
	 public PaymentController(PaymentService service) {
		this.service = service;
	}

	@PostMapping("/charge")
	public ResponseEntity<Boolean> chargeCard(@RequestParam("stripeToken") String stripeToken, @RequestParam("orderId") String orderId) throws Exception {
        service.chargeCard(stripeToken, UUID.fromString(orderId));
		return ResponseEntity.status(HttpStatus.OK).body(true);
    }
	
	@PostMapping("/pix")
	public ResponseEntity<String> payPix(@RequestParam("orderId") String orderId) {
		return ResponseEntity.status(HttpStatus.OK).body("");
   }	
}
