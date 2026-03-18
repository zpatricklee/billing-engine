package com.zpatricklee.billing.model;

import com.zpatricklee.billing.enums.Currency;
import com.zpatricklee.billing.enums.ScheduleStatus;
import com.zpatricklee.billing.enums.BillingFrequency;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class PremiumSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    private String policyId;
    private LocalDate dueDate;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private ScheduleStatus status;
    @Enumerated(EnumType.STRING)
    private BillingFrequency billingFrequency;
    
    public PremiumSchedule() {}

    public PremiumSchedule(String policyId, LocalDate dueDate, Currency currency, BigDecimal amount, ScheduleStatus status, BillingFrequency billingFrequency) {
        this.policyId = policyId;
        this.dueDate = dueDate;
        this.currency = currency;
        this.amount = amount;
        this.status = status;
        this.billingFrequency = billingFrequency;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ScheduleStatus getStatus() {
        return status;
    }

    public void setStatus(ScheduleStatus status) {
        this.status = status;
    }

    public BillingFrequency getBillingFrequency() {
        return billingFrequency;
    }

    public void setBillingFrequency(BillingFrequency billingFrequency) {
        this.billingFrequency = billingFrequency;
    }
    
}
