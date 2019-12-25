package com.Spring.CouponSystem.Beans.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.LoginUser;
import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Beans.Services.CustomerService;
import com.Spring.CouponSystem.Beans.Services.IncomeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("rest/customer")
public class CustomerCTR {

	@Autowired
	private CouponRepo couponRepo;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private IncomeService incomeService;

	public LoginUser getLoggedUser(HttpServletRequest req) {
		System.out.println("inside customer controller" + req.getSession().getAttribute("user"));
		return (LoginUser) req.getSession(false).getAttribute("user");

	}

//	http://localhost:8080/coupon-system/customer/coupon
	@GetMapping("/coupon")
	public List<Coupon> getAllCustomerCoupons(HttpServletRequest req) {
		try {
			return customerService.getAllCustomerCoupons(getLoggedUser(req).getUserId());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	// http://localhost:8080/coupon-system/customer/coupon/couponbytype/{type}
	@GetMapping("/couponbytype/{customerid}/{type}")
	public ResponseEntity<?> getCouponByType(@PathVariable("type") CouponType type, HttpServletRequest req) {
		if (customerService.getCouponsByType(getLoggedUser(req).getUserId(), type) == null) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Coupon>>(customerService.getCouponsByType(getLoggedUser(req).getUserId(), type),
				HttpStatus.OK);

	}

	// http://localhost:8080/coupon-system/customer/coupon/couponbyprice/{price}
	@GetMapping("/couponbyprice/{customerid}/{price}")
	public ResponseEntity<?> getCouponsByPrice(@PathVariable("price") double price, HttpServletRequest req) {
		if (customerService.getCouponsByPrice(getLoggedUser(req).getUserId(), price) == null) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Coupon>>(
				customerService.getCouponsByPrice(getLoggedUser(req).getUserId(), price), HttpStatus.OK);

	}

//	http://localhost:8080/coupon-system/customer/coupon/{customerid}
// 	coupon id = {"id" : 1}
	@PostMapping("/coupon/{customerid}/{companyid}")
	public ResponseEntity<String> purchaseCoupon(@RequestBody Coupon coupon, @PathVariable("companyid") int companyid,
			HttpServletRequest req) {
		try {
			customerService.purchaseCoupon(coupon, companyid, getLoggedUser(req).getUserId());
			return new ResponseEntity<>("Customer purchaed coupon", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}

	
	
	
	
//	@GetMapping("/coupon/{customerid}/{companyid}/{couponid}")
//	public Coupon getOneCoupon(@PathVariable int companyid,@PathVariable int couponid,HttpServletRequest req) {
//		try {
//			return customerService.getOneCoupon(companyid, couponid,getLoggedUser(req).getUserId());
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return null;
//	}

}
