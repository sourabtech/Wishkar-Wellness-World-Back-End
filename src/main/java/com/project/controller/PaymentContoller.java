package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.entity.Payment;
import com.project.service.PaymentService;
import com.wakefit.ecommerce.entity.Product;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2/")
public class PaymentContoller {
	
	@Autowired
	private PaymentService pserv;
	
	@PostMapping("/payment")
	public ResponseEntity<Payment> savePayment(@Valid @RequestBody Payment payment)    // response is give record to postman
	{
		return new ResponseEntity<Payment>(pserv.addPaymentDetail(payment),HttpStatus.CREATED);
	}
	

    @GetMapping("/payment")
    public List<Payment> getAllPayment() {
        return pserv.getAllPayment();
    }
	
	@GetMapping("/payment/{paymentID}")
	public ResponseEntity<Payment> getPayment(@PathVariable("paymentID")  Long paymentID)    // response is give record to postman
	{
		return new ResponseEntity<Payment>(pserv.getPaymentById(paymentID),HttpStatus.OK);
	}
	
	@DeleteMapping("/payment/{paymentID}")
	public ResponseEntity<String> deletePayment(@PathVariable("paymentID")  Long paymentID)    // response is give record to postman
	{
		pserv.deletePaymentDetail(paymentID);
		
		return new ResponseEntity<String>("Delete succefull..", HttpStatus.OK);
	}
	@PutMapping("/payment/{paymentID}")
	public ResponseEntity<String> updatedPayment(@PathVariable("paymentID")  Long paymentID,@Valid @RequestBody Payment payment)    // response is give record to postman
	{
		pserv.updatePaymentDetail(payment, paymentID);
		
		return new ResponseEntity<String>("update succesfully..", HttpStatus.OK);
	}


}
