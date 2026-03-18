package com.zpatricklee.billing.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import com.zpatricklee.billing.enums.PolicyStatus;

@Entity
public class Policy {
    @Id
    private String policyId;
    private String firstName;
    private String lastName;
    private String policyType;
    @Enumerated(EnumType.STRING)
    private PolicyStatus status;
    private BigDecimal premiumAmount;

    public Policy() {}

    public Policy(String policyId, String firstName, String lastName, String policyType, PolicyStatus status, BigDecimal premiumAmount) {
        this.policyId = policyId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.policyType = policyType;
        this.status = status;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public PolicyStatus getStatus() {
        return status;
    }

    public void setStatus(PolicyStatus status) {
        this.status = status;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }
}
