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
import com.Spring.CouponSystem.Beans.Income;
import com.Spring.CouponSystem.Beans.LoginUser;
import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.Spring.CouponSystem.Beans.Services.CustomerService;
import com.Spring.CouponSystem.Beans.Services.IncomeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("rest/customer")
public class CustomerCTR {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private IncomeService incomeService;

	public LoginUser getLoggedUser(HttpServletRequest req) {
		return (LoginUser) req.getSession(false).getAttribute("user");
	}

	@GetMapping("/coupon")
	public ResponseEntity<List<Coupon>> getAllCustomerCoupons(HttpServletRequest req) {
		try {
			List<Coupon> allCustomerCoupons = customerService.getAllCustomerCoupons(getLoggedUser(req).getUserId());
			return new ResponseEntity<List<Coupon>>(allCustomerCoupons, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/couponbytype/{customerid}/{type}")
	public ResponseEntity<?> getCouponByType(@PathVariable("type") CouponType type, HttpServletRequest req) {
		if (customerService.getCouponsByType(getLoggedUser(req).getUserId(), type) == null) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Coupon>>(customerService.getCouponsByType(getLoggedUser(req).getUserId(), type),
				HttpStatus.OK);

	}

	@GetMapping("/couponbyprice/{customerid}/{price}")
	public ResponseEntity<?> getCouponsByPrice(@PathVariable("price") double price, HttpServletRequest req) {
		try {
			List<Coupon> customerCouponsByPrice = customerService.getCouponsByPrice(getLoggedUser(req).getUserId(),
					price);
			return new ResponseEntity<List<Coupon>>(customerCouponsByPrice, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/coupon/{customerid}/{couponid}")
	public ResponseEntity<String> purchaseCoupon(@RequestBody Coupon coupon, HttpServletRequest req) {
		try {
			customerService.purchaseCoupon(coupon, getLoggedUser(req).getUserId());
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/coupon/{couponid}")
	public ResponseEntity<Coupon> getOneCoupon(@PathVariable("couponid") int couponid) {
		try {
			Coupon c = customerService.getOneCouponFromAllCoupons(couponid);
			return new ResponseEntity<Coupon>(c, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/allincomecustomer/{customerid}")
	public ResponseEntity<List<Income>> viewIncomeByCustomerId(HttpServletRequest req) throws Exception {
		try {
			List<Income> allcustomerincome = incomeService.viewIncomeByCustomer(getLoggedUser(req).getUserId());
			return new ResponseEntity<List<Income>>(allcustomerincome, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

}
