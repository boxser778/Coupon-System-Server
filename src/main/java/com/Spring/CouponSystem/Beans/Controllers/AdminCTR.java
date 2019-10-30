package com.Spring.CouponSystem.Beans.Controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.CouponSystem.Session;
import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Services.AdminService;
import com.Spring.CouponSystem.Login.ClientType;
import com.Spring.CouponSystem.Login.CouponClient;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("admin")
public class AdminCTR {

	@Autowired
	AdminService adminService;
	
	@Autowired
	private Map<String, Session> tokens;

//	private Session exists(String token) {
//		return LoginController.tokens.get(token);
//	}
	

//////////////////////////////////////////////////////* GetAll Options *///////////////////////////////////////////////

	// http://localhost:8080/admin/company
	@GetMapping("/company")
	public ResponseEntity<List<Company>> getAllCompanys() {
		return new ResponseEntity<List<Company>>(adminService.findAllCompanies(), HttpStatus.OK);
	}

	// http://localhost:8080/admin/customer
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(adminService.findAllCustomers(), HttpStatus.OK);
	}

	// http://localhost:8080/admin/coupon
	@GetMapping("/coupon")
	public ResponseEntity<List<Coupon>> getAllCoupons() {
		return new ResponseEntity<List<Coupon>>(adminService.findAllCoupons(), HttpStatus.OK);
	}

//////////////////////////////////////////////////////* GetById Options *///////////////////////////////////////////////

	// http://localhost:8080/admin/company/{id}
	@GetMapping("/company/{id}")
	public ResponseEntity<?> getCompany(@PathVariable("id") int id) {
		if (adminService.findCompany(id) == null) {
			return new ResponseEntity<String>("This Id Not Exist!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Company>(adminService.findCompany(id), HttpStatus.OK);
	}

	// http://localhost:8080/admin/customer/{id}
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable("id") int id) {
		if (adminService.findCustomer(id) == null) {
			return new ResponseEntity<String>("This Id Not Exist!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Customer>(adminService.findCustomer(id), HttpStatus.OK);
	}

	// http://localhost:8080/admin/coupon/{id}
	@GetMapping("/coupon/{id}")
	public ResponseEntity<?> getCoupon(@PathVariable("id") int id) {
		if (adminService.findCoupon(id) == null) {
			return new ResponseEntity<String>("This Id Not Exist!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Coupon>(adminService.findCoupon(id), HttpStatus.OK);
	}

//////////////////////////////////////////////////////* Post Options *///////////////////////////////////////////////

	// http://localhost:8080/admin/company
	// {"password":"shmuel","email":"zzz","comp_Name":"wava"}
	@PostMapping("/company")
	public ResponseEntity<?> newCompany(@RequestBody Company c) {
		if (adminService.isCompNameExists(c.getComp_Name()) == false) {
			return new ResponseEntity<String>("name Exist", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Company>(adminService.createCompany(c), HttpStatus.OK);
		}
	}

	// http://localhost:8080/admin/customer
	// {"id":1,"customerName":"shmuel","customerPassword":"zzz"}
	@PostMapping("/customer")
	public ResponseEntity<?> newCustomer(@RequestBody Customer c) {
		if (adminService.isCustNameExists(c.getCustomerName()) == false) {
			return new ResponseEntity<String>("Customer Name Exist", HttpStatus.BAD_REQUEST);
		} else
			return new ResponseEntity<Customer>(adminService.createCustomer(c), HttpStatus.OK);
	}

	// http://localhost:8080/admin/coupon
	// {"id":4,"amount":1,"endDate" : "2006-02-01","msg"
	// :"asdasd","picture":"asdasdasd", "price" : 123, "startDate"
	// :"2006-02-01","title":"shmuel","type" : "FOOD"}
	@PostMapping("/coupon")
	public ResponseEntity<?> newCoupon(@RequestBody Coupon c) {
		if (adminService.isCouponTitleExist(c.getTitle()) == false) {
			return new ResponseEntity<String>("Coupon Title Exist", HttpStatus.BAD_REQUEST);
		} else
			return new ResponseEntity<Coupon>(adminService.createCoupon(c), HttpStatus.OK);
	}

//////////////////////////////////////////////////////* Delete Options *///////////////////////////////////////////////

//		http://localhost:8080/admin/company/{id}
	@DeleteMapping("/company/{id}")
	public ResponseEntity<?> removeCompany(@PathParam("id") Company company) {
		try {
			adminService.deleteCompany(company);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Company Deleled!", HttpStatus.OK);
	}

//		http://localhost:8080/admin/customer/{id}   
	@DeleteMapping("/customer/{id}")   
	public ResponseEntity<?> removeCustomer(@PathParam("id") Customer customer) {
		try {
			adminService.deleteCustomer(customer);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Customer Deleled!", HttpStatus.OK);
	}

//	http://localhost:8080/admin/coupon/{id}
	@DeleteMapping("/coupon/{id}")
	public ResponseEntity<?> removeCoupon(@PathParam("id") Coupon coupon) {
		try {
			adminService.deleteCoupon(coupon);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Coupon Deleled!", HttpStatus.OK);
	}

//////////////////////////////////////////////////////* Update Options *///////////////////////////////////////////////
	
	@PutMapping("/company/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable("id") int id, @RequestBody Company company) {
		try {
			adminService.updateCompany(company);
		} catch (Exception e) {
			return new ResponseEntity<Company>(company, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}

	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
		try {
			adminService.updateCustomer(customer);
		} catch (Exception e) {
			return new ResponseEntity<Customer>(customer, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PutMapping("/coupon/{id}")
	public ResponseEntity<?> updateCoupon(@PathVariable("id") int id, @RequestBody Coupon coupon) {
		try {
			adminService.updateCoupon(coupon);
		} catch (Exception e) {
			return new ResponseEntity<String>("Some problem", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Coupon>(coupon, HttpStatus.OK);
	}
	
}
