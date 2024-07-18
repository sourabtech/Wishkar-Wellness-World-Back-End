package com.project.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.entity.Payment;
import com.project.exception.PaymentNotFoundException;
import com.project.repository.PaymentRepository;
import com.project.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository prepo;
	
	@Override
	public Payment addPaymentDetail(Payment payment) {
		// TODO Auto-generated method stub
		return prepo.save(payment);
	}

	@Override
	public Payment getPaymentById(Long paymentID) {
		// TODO Auto-generated method stub
		return prepo.findById(paymentID).
				orElseThrow(()-> new PaymentNotFoundException("payment Info not correct"));  
	}

	@Override
	public Payment updatePaymentDetail(Payment payment, Long paymentID) {
		// TODO Auto-generated method stub
		Payment pay = prepo.findById(paymentID)
                .orElseThrow(() -> new PaymentNotFoundException("paymentwith ID " + paymentID + " not found"));
		
		pay.setAmount(pay.getAmount());
		pay.setPaymentDateTime(pay.getPaymentDateTime());
		pay.setPaymentID(pay.getPaymentID());
		pay.setPaymentMethod(pay.getPaymentMethod());
		pay.setUserID(pay.getUserID());
		return prepo.save(pay);
	}

	@Override
	public Payment deletePaymentDetail(Long paymentID) {
		// TODO Auto-generated method stub
		Payment pay = prepo.findById(paymentID)
                .orElseThrow(() -> new PaymentNotFoundException("payment  not found"));
        prepo.delete(pay);
		return pay;	
	}

	@Override
	public List<Payment> getAllPayment() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

}
