package com.zpatricklee.billing.controller;

import com.zpatricklee.billing.model.Policy;
import com.zpatricklee.billing.model.PremiumSchedule;
import com.zpatricklee.billing.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @GetMapping("/{policyId}/premium-schedule")
    public ResponseEntity<List<PremiumSchedule>> getPremiumSchedules(@PathVariable String policyId) {
        List<PremiumSchedule> schedules = policyService.getPremiumSchedules(policyId);
        if (schedules == null || schedules.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(schedules);
        }
    }    

    @GetMapping("/delinquent")
    public ResponseEntity<List<Policy>> getDelinquentPolicies() {
        List<Policy> policies = policyService.getDelinquentPolicies();
        if (policies == null || policies.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(policies);
        }
    }
}
