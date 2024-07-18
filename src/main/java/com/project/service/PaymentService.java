package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Payment;
import com.project.entity.Product;

@Service
public interface PaymentService {
	
	  Payment addPaymentDetail (Payment payment);
	
	  Payment getPaymentById(Long paymentID);
	
	  Payment updatePaymentDetail(Payment payment, Long paymentID);

	  Payment deletePaymentDetail(Long paymentID);
	  
		List<Payment> getAllPayment();

}
