package com.zpatricklee.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.zpatricklee.billing.model.Policy;
import com.zpatricklee.billing.enums.PolicyStatus;

public interface PolicyRepository extends JpaRepository<Policy, String> {
    List<Policy> findByStatus(PolicyStatus status);
}
