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
import com.Spring.CouponSystem.Beans.Services.CompanyService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("company")
public class CompanyCTR {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private Map<String, Session> tokens;
	
//	@PostMapping("/coupon")
//	public ResponseEntity<?> newCoupon(@RequestBody Coupon c) throws Exception {
//		if (companyService.isCouponTitleExist(c.getTitle()) == false) {
//			return new ResponseEntity<String>("Coupon Title Exist", HttpStatus.BAD_REQUEST);
//		} else
//			return new ResponseEntity<Coupon>(companyService.createCoupon(c), HttpStatus.OK);
//	}
	
	

	@PostMapping(value = "/createCoupon",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public ResponseEntity<String> createCoupon(@RequestBody Coupon coupon){
			try {
				companyService.createCoupon(coupon);
				return new ResponseEntity<>("coupon created  " + coupon, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(e.getMessage() + e.getStackTrace(), HttpStatus.UNAUTHORIZED);
			}

}
	
	
	@PutMapping("/coupon/{id}")
	public ResponseEntity<?> updateCoupon(@PathVariable("id") int id, @RequestBody Coupon coupon) {
		try {
			companyService.updateCoupon(coupon);
		} catch (Exception e) {
			return new ResponseEntity<String>("Some problem", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Coupon>(coupon, HttpStatus.OK);
	}

	@DeleteMapping("/coupon/{id}")
	public ResponseEntity<?> removeCoupon(@PathParam("id") Coupon coupon) {
		try {
			companyService.deleteCoupon(coupon);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Coupon Deleled!", HttpStatus.OK);
	}
	
	
	@GetMapping("/company/{id}")
	public ResponseEntity<?> getCompany(@PathVariable("id") int id) {
		if (companyService.findCompany(id) == null) {
			return new ResponseEntity<String>("This Id Not Exist!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Company>(companyService.findCompany(id), HttpStatus.OK);
	}

	@GetMapping("/coupon")
	public ResponseEntity<List<Coupon>> getAllCoupons() {
		return new ResponseEntity<List<Coupon>>(companyService.findAllCoupons(), HttpStatus.OK);
	}

	@GetMapping("/couponByDate/{date}")
	public ResponseEntity<List<Coupon>> getCouponByDate(@PathVariable("date") String endDate) {
		Date asDate = new Date(Long.parseLong(endDate));
		return new ResponseEntity<List<Coupon>>(companyService.getCouponsByEndDate(asDate), HttpStatus.OK);
	}

	@GetMapping("/couponByPrice/{price}")
	public ResponseEntity<?> getCouponByDate(@PathVariable("price") double price) {
		if (companyService.getCouponsByPrice(price) == null) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Coupon>>(companyService.getCouponsByPrice(price), HttpStatus.OK);

	}

	@GetMapping("/couponByType/{type}")
	public ResponseEntity<?> getCouponByType(@PathVariable("type") CouponType type) {
		if (companyService.getCouponsByType(type) == null) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Coupon>>(companyService.getCouponsByType(type), HttpStatus.OK);

	}

	@GetMapping("/coupon/{id}")
	public ResponseEntity<?> getCoupon(@PathVariable("id") int id) {
		if (companyService.findCoupon(id) == null) {
			return new ResponseEntity<String>("This Id Not Exist!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Coupon>(companyService.findCoupon(id), HttpStatus.OK);
	}
	
	@PutMapping("/company/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable("id") int id, @RequestBody Company company) {
		try {
			companyService.updateCompany(company);
		} catch (Exception e) {
			return new ResponseEntity<Company>(company, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}


}
