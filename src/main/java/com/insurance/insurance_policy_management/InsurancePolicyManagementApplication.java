package com.insurance.insurance_policy_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.insurance.insurance_policy_management",
		"com.bs.insurance.backend"
})
@EnableJpaRepositories(basePackages = "com.bs.insurance.backend.repository")
@EntityScan("com.bs.insurance.backend.entity")
public class InsurancePolicyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsurancePolicyManagementApplication.class, args);
	}

}
