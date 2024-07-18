package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
