package com.Spring.CouponSystem.Beans.Controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.Spring.CouponSystem.Beans.Repository.CustomerRepo;
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

	private Session exists(String token) {
		return LoginController.tokens.get(token);
	}

	// http://localhost:8080/coupon-system/admin/company
	@GetMapping("/company")
	public ResponseEntity<List<Company>> getAllCompanys() {
		return new ResponseEntity<List<Company>>(adminService.findAllCompanies(), HttpStatus.OK);
	}

	// http://localhost:8080/coupon-system/admin/customer
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(adminService.findAllCustomers(), HttpStatus.OK);
	}

	// http://localhost:8080/coupon-system/admin/company/{id}
	@GetMapping("/company/{id}/{token}")
	public ResponseEntity<?> getCompany(@PathVariable("id") int id, @PathVariable String token) throws Exception {
		Session session = exists(token);
		if (session == null) {
			throw new Exception("Something went wrong with the session !!");
		} else if (session != null) {
			session.setLastAccesed(System.currentTimeMillis());
		}
		try {
			return new ResponseEntity<Company>(adminService.findCompany(id), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("This Id Not Exist!", HttpStatus.BAD_REQUEST);
		}

	}

	// http://localhost:8080/coupon-system/admin/customer/{id}
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable("id") int id) {
		if (adminService.findCustomer(id) == null) {
			return new ResponseEntity<String>("This Id Not Exist!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Customer>(adminService.findCustomer(id), HttpStatus.OK);
	}

	// http://localhost:8080/coupon-system/admin/company
	// {"password":"shmuel","email":"zzz","comp_Name":"wava"}
	@PostMapping("/company")
	public ResponseEntity<?> newCompany(@RequestBody Company c) {
		if (adminService.isCompNameExists(c.getComp_Name()) == false) {
			return new ResponseEntity<String>("name Exist", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Company>(adminService.createCompany(c), HttpStatus.OK);
		}
	}

	// http://localhost:8080/coupon-system/admin/customer
	// {"customerName":"shmuel","customerPassword":"zzz"}
	@PostMapping("/customer")
	public ResponseEntity<?> newCustomer(@RequestBody Customer c) {
		if (adminService.isCustNameExists(c.getCustomerName()) == false) {
			return new ResponseEntity<String>("Customer Name Exist", HttpStatus.BAD_REQUEST);
		} else
			return new ResponseEntity<Customer>(adminService.createCustomer(c), HttpStatus.OK);
	}

//		http://localhost:8080/coupon-system/admin/company/{id}
	@DeleteMapping("/company/{id}")
	public ResponseEntity<?> removeCompany(@PathVariable("id") Company company) {
		try {
			adminService.deleteCompany(company);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Company Deleled!", HttpStatus.OK);
	}

//		http://localhost:8080/coupon-system/admin/customer/{id}   
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> removeCustomer(@PathVariable("id") Customer customer) {
		try {
			adminService.deleteCustomer(customer);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed!", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Customer Deleled!", HttpStatus.OK);
	}
	
//	http://localhost:8080/coupon-system/admin/company/{id} 
	@PutMapping("/company/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable("id") int id, @RequestBody Company company) {
		try {
			adminService.updateCompany(company);
		} catch (Exception e) {
			return new ResponseEntity<Company>(company, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}

//	http://localhost:8080/coupon-system/admin/customer/{id} 
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
		try {
			adminService.updateCustomer(customer);
		} catch (Exception e) {
			return new ResponseEntity<Customer>(customer, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
