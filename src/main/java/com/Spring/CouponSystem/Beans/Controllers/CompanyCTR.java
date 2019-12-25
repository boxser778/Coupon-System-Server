package com.Spring.CouponSystem.Beans.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.LoginUser;
import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Beans.Services.CompanyService;
import com.Spring.CouponSystem.Beans.Services.IncomeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("rest/company")
public class CompanyCTR {

	@Autowired
	private CompanyService companyService;

	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	CouponRepo couponRepo;

	@Autowired
	IncomeService incomeService;

	public LoginUser getLoggedUser(HttpServletRequest req) {
		System.out.println("inside company controller" + req.getSession().getAttribute("user"));
		return (LoginUser) req.getSession(false).getAttribute("user");

	}

//	http://localhost:8080/coupon-system/company/coupon/{companyId}
//	{
//	    "title": "adaddd333dad",
//	    "amount": 1,
//	    "endDate": 1571097600000,
//	    "type": "CLOTHING",
//	    "msg": "aaa",
//	    "price": 22,
//	    "picture": "https://analyticsindiamag.com/wp-content/uploads/2019/07/image_rec_lib_banner.jpg"
//	}
	@PostMapping(value = "/coupon/{companyid}")
	@ResponseBody
	public ResponseEntity<String> createCoupon(@RequestBody Coupon coupon, HttpServletRequest req) {
		try {
			companyService.createCoupon(coupon, getLoggedUser(req).getUserId());
			return new ResponseEntity<>("coupon created", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage() + e.getStackTrace(), HttpStatus.UNAUTHORIZED);
		}

	}

//	http://localhost:8080/coupon-system/company/coupon/{couponid}
	@DeleteMapping("/coupon/{companyid}/{couponid}")
	public ResponseEntity<?> removeCoupon(@PathVariable("couponid") int couponid) {
		try {
			companyService.deleteCoupon(couponid);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Coupon Deleled!", HttpStatus.OK);
	}

//	http://localhost:8080/coupon-system/company/coupon/{companyid}
	@PutMapping("/coupon/{companyid}")
	public ResponseEntity<?> updateCoupon(HttpServletRequest req, @RequestBody Coupon coupon) {
		try {
			companyService.updateCoupon(getLoggedUser(req).getUserId(), coupon);
		} catch (Exception e) {
			return new ResponseEntity<String>("Coupon updated", HttpStatus.OK);
		}
		return new ResponseEntity<String>("some problem", HttpStatus.BAD_REQUEST);
	}

//	http://localhost:8080/coupon-system/company/coupon/{companyid}
	@ResponseBody
	@GetMapping(value = "/company/{companyid}")
	public Company getCompany(HttpServletRequest req) {
		try {
			Company c = companyService.findById(getLoggedUser(req).getUserId());
			return c;
		} catch (NullPointerException e) {
			throw new IllegalStateException(e);
		}
	}

//	http://localhost:8080/coupon-system/company/coupon
	@GetMapping("/coupon")
	public List<Coupon> getAllCompanyCoupons(HttpServletRequest req) {
		try {
			return companyService.getAllCompanyCoupons(getLoggedUser(req).getUserId());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

//	http://localhost:8080/coupon-system/company/coupon/couponbyprice/{price}
	@GetMapping("/couponbyprice/{companyid}/{price}")
	public ResponseEntity<?> getCouponByPrice(@PathVariable("price") double price, HttpServletRequest req) {
		if (companyService.getCouponsByPrice(getLoggedUser(req).getUserId(), price) == null) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Coupon>>(companyService.getCouponsByPrice(getLoggedUser(req).getUserId(), price),
				HttpStatus.OK);

	}

//	http://localhost:8080/coupon-system/company/coupon/{couponid}
	@GetMapping("/coupon/{companyid}/{couponid}")
	public Coupon getOneCoupon(HttpServletRequest req, @PathVariable int couponid) {
		try {
			return companyService.findOneCoupon(getLoggedUser(req).getUserId(), couponid);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

//	http://localhost:8080/coupon-system/company/coupon/couponbytype/{type}
	@GetMapping("/couponbytype/{companyid}/{type}")
	public ResponseEntity<?> getCouponByType(@PathVariable("type") CouponType type, HttpServletRequest req) {
		if (companyService.getCouponsByType(getLoggedUser(req).getUserId(), type) == null) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Coupon>>(companyService.getCouponsByType(getLoggedUser(req).getUserId(), type),
				HttpStatus.OK);

	}

//	@GetMapping("/viewIncomeByCompanyId/{companyId}")
//	public List<Income> viewIncomeByCompanyId(@PathVariable int companyId, HttpServletRequest req) {
//			try {
//				return incomeService.viewIncomeByCompany(companyId);
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		
//		return null;
//	}
}
