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
import com.Spring.CouponSystem.Beans.Income;
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

	@DeleteMapping("/coupon/{companyid}/{couponid}")
	public ResponseEntity<?> removeCoupon(@PathVariable("couponid") int couponid) {
		try {
			companyService.deleteCoupon(couponid);
		} catch (Exception e) {
			System.out.println("Coupon were not been able to delete");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		System.out.println("Coupon Deleted!!");
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PutMapping("/coupon/{companyid}")
	public ResponseEntity<?> updateCoupon(HttpServletRequest req, @RequestBody Coupon coupon) {
		try {
			companyService.updateCoupon(getLoggedUser(req).getUserId(), coupon);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "/company/{companyid}")
	public ResponseEntity<Company> getCompany(HttpServletRequest req) {
		try {
			Company c = companyService.findById(getLoggedUser(req).getUserId());
			return new ResponseEntity<Company>(c, HttpStatus.OK);
		} catch (NullPointerException e) {
			throw new IllegalStateException(e);
		}
	}

	@GetMapping("/coupon")
	public ResponseEntity<List<Coupon>> getAllCompanyCoupons(HttpServletRequest req) {
		try {
			List<Coupon> companyCoupons = companyService.getAllCompanyCoupons(getLoggedUser(req).getUserId());
			return new ResponseEntity<List<Coupon>>(companyCoupons, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/couponbyprice/{companyid}/{price}")
	public ResponseEntity<?> getCouponByPrice(@PathVariable("price") double price, HttpServletRequest req) {
		if (companyService.getCouponsByPrice(getLoggedUser(req).getUserId(), price) == null) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Coupon>>(companyService.getCouponsByPrice(getLoggedUser(req).getUserId(), price),
				HttpStatus.OK);

	}

	@GetMapping("/coupon/{companyid}/{couponid}")
	public ResponseEntity<Coupon> getOneCoupon(HttpServletRequest req, @PathVariable int couponid) {
		try {
			Coupon c = companyService.findOneCoupon(getLoggedUser(req).getUserId(), couponid);
			return new ResponseEntity<Coupon>(c, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/couponbytype/{companyid}/{type}")
	public ResponseEntity<?> getCouponByType(@PathVariable("type") CouponType type, HttpServletRequest req) {
		if (companyService.getCouponsByType(getLoggedUser(req).getUserId(), type) == null) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Coupon>>(companyService.getCouponsByType(getLoggedUser(req).getUserId(), type),
				HttpStatus.OK);

	}

	@GetMapping("/allincomecompany/{companyid}")
	public ResponseEntity<List<Income>> viewIncomeByCompanyId(HttpServletRequest req) throws Exception {
		try {
			List<Income> allcompanyincome = incomeService.viewIncomeByCompany(getLoggedUser(req).getUserId());
			return new ResponseEntity<List<Income>>(allcompanyincome, HttpStatus.OK);
		} catch (Exception e) {

		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

//	@GetMapping("/couponbyenddate/{companyid}/{enddate}")
//	public ResponseEntity<List<Coupon>> getCouponByEndDate(@PathVariable("enddate") Date endDate,
//			HttpServletRequest req) throws ParseException {
//		List<Coupon> couponsbyenddate = companyService.getCouponsByEndDate(getLoggedUser(req).getUserId(), endDate);
//		return new ResponseEntity<>(couponsbyenddate, HttpStatus.OK);
//	}

}
