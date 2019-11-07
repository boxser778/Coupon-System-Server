package com.Spring.CouponSystem.Beans.Controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.CouponSystem.Session;
import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Services.CompanyService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("company")
public class CompanyCTR {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private Map<String, Session> tokens;

	@Autowired
	CompanyRepo companyRepo;

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

	@PostMapping(value = "/coupon/{companyId}")
	@ResponseBody
	public ResponseEntity<String> createCoupon(@RequestBody Coupon coupon, @PathVariable("companyId") int companyId) {
		try {
			companyService.createCoupon(coupon, companyId);
			return new ResponseEntity<>("coupon created", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage() + e.getStackTrace(), HttpStatus.UNAUTHORIZED);
		}

	}
//	http://localhost:8080/coupon-system/company/coupon/{companyId}
	@PutMapping("/coupon/{id}")
	public ResponseEntity<?> updateCoupon(@PathVariable("id") int id, @RequestBody Coupon coupon) {
		try {
			companyService.updateCoupon(coupon);
		} catch (Exception e) {
			return new ResponseEntity<String>("Some problem", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Coupon>(coupon, HttpStatus.OK);
	}
//	http://localhost:8080/coupon-system/company/coupon/{companyId}
	@DeleteMapping("/coupon/{id}")
	public ResponseEntity<?> removeCoupon(@PathParam("id") Coupon coupon) {
		try {
			companyService.deleteCoupon(coupon);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Coupon Deleled!", HttpStatus.OK);
	}
//	http://localhost:8080/coupon-system/company/company/{companyId}
	@GetMapping("/company/{id}")
	public ResponseEntity<?> getCompany(@PathVariable("id") int id) {
		if (companyService.findById(id) == null) {
			return new ResponseEntity<String>("This Id Not Exist!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Company>(companyService.findById(id), HttpStatus.OK);
	}
//	http://localhost:8080/coupon-system/company/coupon/{companyId}
	@GetMapping("/coupon/{companyid}")
	public List<Coupon> getAllCompanyCoupons(@PathVariable int companyid) {
		try {
			return companyService.getAllCompanyCoupons(companyid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@GetMapping("/couponbyenddate/{companyid}/{date}")
	public ResponseEntity<List<Coupon>> getCouponsByEndDate(@PathVariable("date") String endDate,@PathVariable("companyid") int companyid) {
		Date asDate = new Date(Long.parseLong(endDate));
		return new ResponseEntity<List<Coupon>>(companyService.getCouponsByEndDate(companyid,asDate), HttpStatus.OK);
	}

	@GetMapping("/couponbyprice/{companyid}/{price}")
	public ResponseEntity<?> getCouponByPrice(@PathVariable("price") double price,@PathVariable("companyid") int companyid) {
		if (companyService.getCouponsByPrice(companyid, price) == null) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Coupon>>(companyService.getCouponsByPrice(companyid, price), HttpStatus.OK);

	}

	@GetMapping("/couponbytype/{companyid}/{type}")
	public ResponseEntity<?> getCouponByType(@PathVariable("type") CouponType type,@PathVariable("companyid") int companyid) {
		if (companyService.getCouponsByType(companyid, type) == null) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Coupon>>(companyService.getCouponsByType(companyid, type), HttpStatus.OK);

	}

}
