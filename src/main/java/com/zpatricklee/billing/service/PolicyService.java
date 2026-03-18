package com.zpatricklee.billing.service;

import com.zpatricklee.billing.enums.PolicyStatus;
import com.zpatricklee.billing.model.Policy;
import com.zpatricklee.billing.model.PremiumSchedule;
import com.zpatricklee.billing.repository.PolicyRepository;
import com.zpatricklee.billing.repository.PremiumScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {
    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private PremiumScheduleRepository premiumScheduleRepository;

    public List<Policy> getDelinquentPolicies() {
        try {
            return policyRepository.findByStatus(PolicyStatus.DELINQUENT);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving delinquent policies", e);
        }
    }

    public List<PremiumSchedule> getPremiumSchedules(String policyId) {
        try {
            return premiumScheduleRepository.findByPolicyId(policyId.toUpperCase());
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving premium schedules", e);
        }
    }
}
