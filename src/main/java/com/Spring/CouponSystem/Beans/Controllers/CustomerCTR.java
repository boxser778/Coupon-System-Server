package com.Spring.CouponSystem.Beans.Controllers;

import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.CouponSystem.Session;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Login.ClientType;
import com.Spring.CouponSystem.Login.CouponClient;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("customer")
public class CustomerCTR {

	@Autowired
	private CouponRepo couponRepo;
	
	@Autowired
	private Map<String, Session> tokens;

//	private Session exists(String token) {
//		return LoginController.tokens.get(token);
//	}
	
	// http://localhost:8080/customer/coupon
		@GetMapping("/coupon")
		public List<Coupon> getAllCoupons() {
			return couponRepo.findAll();
		}
		

		
//		public CustomerCTR login(String name, String password, ClientType clientType) throws LoginException, Exception {
//			
//			if (name.equals("customer") && password.equals("customer") && clientType.equals(ClientType.CUSTOMER)) {
//			
//		}
//			return new CustomerCTR();
//
//		}
		
		
		
		
		
		
//		@Autowired
//		private CustomerService customerService;
//		
//
//		@Autowired
//		private Map<String, Session> tokens;
//
//		private Session exists(String token) {
//			return LoginController.tokens.get(token);
//		}
//
////		 @PostMapping("/purchaseCoupon/{token}")
////		 public ResponseEntity<Customer> purchaseCoupon (@PathVariable long couponId,
////		 @PathVariableString token) throws Exception{
////		 Customer customer = customerService.purchaseCoupon(couponId);
////		 ResponseEntity<Customer> result = new
////		 ResponseEntity<Customer>(customer,HttpStatus.OK);
////		 return result;
////		 }
//		
//		@PostMapping("/purchaseCoupon/{couponId}/{token}")
//		public ResponseEntity<String> purchaseCoupon(@PathVariable long couponId, @PathVariable String token)
//				throws Exception {
//			Session session = exists(token);
//			if (session == null) {
//				throw new Exception("Something went wrong with the session !!");
//			} else if (session != null) {
//				session.setLastAccesed(System.currentTimeMillis());
//				try {
//					if (((CustomerServiceImpl) session.getFacade()).purchaseCoupon(couponId) != null) {
//					}return new ResponseEntity<>("Customer purchaed coupon :  " + couponId, HttpStatus.OK);
//				} catch (Exception e) {
//					return new ResponseEntity<>(e.getMessage() + e.getStackTrace(), HttpStatus.UNAUTHORIZED);
//				}
//			}
//			return null;
//		}
//
//		@GetMapping("/getAllCustomerCoupons/{customer_id}/{token}")
//		public List<Coupon> getAllCustomerCoupons(@PathVariable long customer_id, @PathVariable String token)
//				throws Exception {
//			Session session = exists(token);
//			if (session == null) {
//				throw new Exception("Something went wrong with the session !!");
//			} else if (session != null) {
//				session.setLastAccesed(System.currentTimeMillis());
//				try {
//					return ((CustomerServiceImpl) session.getFacade()).getAllCustomerCoupons(customer_id);
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//			}
//			return null;
//		}
//		
//		@GetMapping("/getCouponsByCouponType/{couponType}/{token}")
//		public List<Coupon> getCouponsByCouponType(@PathVariable CouponType couponType, @PathVariable String token)
//				throws Exception {
//			Session session = exists(token);
//			if (session == null) {
//				throw new Exception("Something went wrong with the session !!");
//			} else if (session != null) {
//				session.setLastAccesed(System.currentTimeMillis());
//				try {
//					return ((CustomerServiceImpl) session.getFacade()).getCouponsByCouponType(couponType);
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//			}
//			return null;
//		}
//		
//		@GetMapping("/getCouponsByPrice/{price}/{token}")
//		public List<Coupon> getCouponsByPrice(@PathVariable double price, @PathVariable String token)
//				throws Exception {
//			Session session = exists(token);
//			if (session == null) {
//				throw new Exception("Something went wrong with the session !!");
//			} else if (session != null) {
//				session.setLastAccesed(System.currentTimeMillis());
//				try {
//					return ((CustomerServiceImpl) session.getFacade()).getCouponsByPrice(price);
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//			}
//			return null;
//		}
//		
//	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
