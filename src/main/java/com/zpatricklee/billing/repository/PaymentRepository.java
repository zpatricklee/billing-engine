package com.zpatricklee.billing.repository;

import com.zpatricklee.billing.model.PaymentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentRecord, String> {
}
