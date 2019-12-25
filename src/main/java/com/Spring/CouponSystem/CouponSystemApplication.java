package com.Spring.CouponSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
@ComponentScan
public class CouponSystemApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CouponSystemApplication.class, args);
		System.out.println("Coupon System Application is initiated....");
	
	}

}

