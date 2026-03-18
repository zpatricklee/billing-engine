package com.zpatricklee.billing.service;

import com.zpatricklee.billing.DTO.PaymentRequest;
import com.zpatricklee.billing.DTO.PaymentResponse;
import com.zpatricklee.billing.enums.PaymentStatus;
import com.zpatricklee.billing.model.PaymentRecord;
import com.zpatricklee.billing.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        String paymentId = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
        PaymentRecord paymentRecord = new PaymentRecord(
            paymentId,
            paymentRequest.policyId(),
            paymentRequest.amount(),
            paymentRequest.paymentMethod()
        );
        paymentRecord.setPaymentDateTime(java.time.LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        if (paymentRequest.policyId().equals("POL123")) {
            paymentRecord.setPaymentStatus(PaymentStatus.FAILED);
            paymentRepository.save(paymentRecord);
            return new PaymentResponse(false, paymentId); // Simulate failed payment
        } else {
            paymentRecord.setPaymentStatus(PaymentStatus.PROCESSED);
            paymentRepository.save(paymentRecord);
            return new PaymentResponse(true, paymentId); // Simulate success payment
        }
    }

    public boolean retryPayment(String paymentId) {
        Optional<PaymentRecord> paymentRecord = paymentRepository.findById(paymentId);
        if (paymentRecord.isPresent() && paymentRecord.get().getPaymentStatus().equals(PaymentStatus.FAILED)) {
            paymentRecord.get().setPaymentStatus(PaymentStatus.PROCESSED);
            paymentRecord.get().setPaymentDateTime(java.time.LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
            paymentRepository.save(paymentRecord.get());
            return true;
        } else {
            return false;
        }
    }
}
