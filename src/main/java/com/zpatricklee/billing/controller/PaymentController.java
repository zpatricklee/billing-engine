package com.zpatricklee.billing.controller;

import DTO.PaymentRequest;
import DTO.PaymentResponse;
import com.zpatricklee.billing.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest) {
        PaymentResponse response = paymentService.processPayment(paymentRequest);
        if (response.success()) {
            return ResponseEntity.status(HttpStatus.CREATED)
                .body("Payment processed successfully. Payment ID: " + response.paymentId());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body("Payment failed - will retry. Payment ID: " + response.paymentId());
        }
    }

    @PostMapping("/retry")
    public ResponseEntity<String> retryPayment(@RequestParam String id) {
        boolean response = paymentService.retryPayment(id);
        if (response) {
            return ResponseEntity.status(HttpStatus.OK)
                .body("Payment retried successfully. Payment ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Unable to process payment - will retry. Payment ID: " + id);
        }
    }
}
