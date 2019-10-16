package com.Spring.CouponSystem.Beans.Controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.CouponSystem.CouponSystem;
import com.Spring.CouponSystem.Session;
import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Repository.CustomerRepo;
import com.Spring.CouponSystem.Beans.Services.AdminService;
import com.Spring.CouponSystem.Beans.Services.CompanyService;
import com.Spring.CouponSystem.Beans.Services.CustomerService;
import com.Spring.CouponSystem.Login.ClientType;
import com.Spring.CouponSystem.Login.CouponClient;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("Login")
public class LoginController {

	
	public static Map<String, Session> tokens = new HashMap<String, Session>();
	
	@Autowired
	private CouponSystem couponSystem;

	
	@PostMapping("login")
	public ResponseEntity<String>login(@RequestParam String name, @RequestParam String password, @RequestParam String clientType){
		if (!clientType.equals("ADMIN") && !clientType.equals("COMPANY") && !clientType.equals("CUSTOMER")) {
			return new ResponseEntity<>("Check clientType again", HttpStatus.UNAUTHORIZED);
		}
		
		Session session = new Session();
		CouponClient facade = null;
		String token = UUID.randomUUID().toString();
		long lastAccessed=System.currentTimeMillis();
		
		try {
			facade=couponSystem.login(name, password, ClientType.valueOf(clientType));
			session.setFacade(facade);
			session.setLastAccesed(lastAccessed);
			tokens.put(token, session);
			return new ResponseEntity<>(token,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.UNAUTHORIZED);
		}
	}
			
	}
	
	
