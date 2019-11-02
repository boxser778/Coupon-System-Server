package com.Spring.CouponSystem.Beans.Controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.CouponSystem.Session;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Beans.Services.CustomerService;
import com.Spring.CouponSystem.Login.ClientType;
import com.Spring.CouponSystem.Login.CouponClient;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("customer")
public class CustomerCTR {

	@Autowired
	private CouponRepo couponRepo;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private Map<String, Session> tokens;

//	private Session exists(String token) {
//		return LoginController.tokens.get(token);
//	}

//	http://localhost:8080/coupon-system/customer/coupon/{customerid}
// 	coupon id = {"id" : 1}
	@PostMapping("/coupon/{customerid}")
	public ResponseEntity<String> purchaseCoupon(@RequestBody Coupon coupon,
			@PathVariable("customerid") int customerId) {
		try {
			customerService.purchaseCoupon(coupon, customerId);
			return new ResponseEntity<>("Customer purchaed coupon", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}

//	http://localhost:8080/coupon-system/customer/coupon/{customerid}
	@GetMapping("/coupon/{customerid}")
	public List<Coupon> getAllCustomerCoupons(@PathVariable int customerid) {
		try {
			return customerService.getAllCustomerCoupons(customerid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

//	@GetMapping("/couponbytype/{type}")
//	public ResponseEntity<?> getCouponByType(@PathVariable("type") CouponType type) {
//		if (customerService.getCouponsByType(type) == null) {
//			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<List<Coupon>>(customerService.getCouponsByType(type), HttpStatus.OK);
//
//	}

//	@GetMapping("/couponbyprice/{price}")
//	public ResponseEntity<?> getCouponsByPrice(@PathVariable("price") double price) throws Exception {
//		if (customerService.findCustomerCouponsByPrice(price) == null) {
//			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<List<Coupon>>(customerService.findCustomerCouponsByPrice(price), HttpStatus.OK);
//
//	}

}

//		public CustomerCTR login(String name, String password, ClientType clientType) throws LoginException, Exception {
//			
//			if (name.equals("customer") && password.equals("customer") && clientType.equals(ClientType.CUSTOMER)) {
//			
//		}
//			return new CustomerCTR();
//
//		}
