package com.zpatricklee.billing.repository;

import com.zpatricklee.billing.model.PremiumSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PremiumScheduleRepository extends JpaRepository<PremiumSchedule, String> {
    List<PremiumSchedule> findByPolicyId(String policyId);
}
