package com.lld.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lld.bms.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
