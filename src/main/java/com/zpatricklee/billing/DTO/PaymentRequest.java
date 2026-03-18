package com.zpatricklee.billing.DTO;

import com.zpatricklee.billing.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
    String policyId,
    BigDecimal amount,
    PaymentMethod paymentMethod
) {}
