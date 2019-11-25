package com.Spring.CouponSystem;

import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.Spring.CouponSystem.Beans.Services.AdminService;
import com.Spring.CouponSystem.Login.ClientType;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan
public class CouponSystemApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CouponSystemApplication.class, args);
		System.out.println("Coupon System Application is initiated....");
	}
	
	
	
}

//<dependency>
//	<groupId>org.springframework.boot</groupId>
//	<artifactId>spring-boot-starter-security</artifactId>
//</dependency>
//<dependency>
//	<groupId>org.springframework.boot</groupId>
//	<artifactId>spring-boot-starter-security</artifactId>
//</dependency>
//<dependency>
//	<groupId>io.jsonwebtoken</groupId>
//	<artifactId>jjwt</artifactId>
//	<version>0.9.1</version>
//</dependency>