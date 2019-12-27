package com.Spring.CouponSystem.Beans.Controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Income;
import com.Spring.CouponSystem.Beans.Services.AdminService;
import com.Spring.CouponSystem.Beans.Services.IncomeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("rest/admin")
public class AdminCTR {

	@Autowired
	AdminService adminService;

	@Autowired
	IncomeService incomeService;

	@GetMapping("/company")
	public ResponseEntity<List<Company>> getAllCompanys() {
		return new ResponseEntity<List<Company>>(adminService.findAllCompanies(), HttpStatus.OK);
	}

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(adminService.findAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("/company/{id}")
	public ResponseEntity<?> getCompany(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Company>(adminService.findCompany(id), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("This Id Not Exist!", HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<Customer>(adminService.findCustomer(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("This Id Not Exist!", HttpStatus.BAD_REQUEST);
		}
	}

	// http://localhost:8080/coupon-system/admin/company
	// {"password":"shmuel","email":"zzz","comp_Name":"wava"}
	@PostMapping("/company")
	public ResponseEntity<?> newCompany(@RequestBody Company c) throws Exception {
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

	@DeleteMapping("/company/{id}")
	public ResponseEntity<?> removeCompany(@PathVariable("id") Company company) {
		try {
			adminService.deleteCompany(company);
		} catch (Exception e) {
			System.out.println("there was an error with deleting this client");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		System.out.println("Company Deleted!");
		return new ResponseEntity<String>(HttpStatus.OK);
	}
  
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> removeCustomer(@PathVariable("id") int customerId) {
		try {
			adminService.deleteCustomer(customerId);
		} catch (Exception e) {
			System.out.println("there was an error with deleting this client");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		System.out.println("Customer Deleted!");
		return new ResponseEntity<String>(HttpStatus.OK);
	}

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
	
	@GetMapping("/allincomecompany/{companyid}")
	public List<Income> viewIncomeByCompanyId(@PathVariable("companyid") int companyid) throws Exception {
		List<Income> allcompanyincome = incomeService.viewIncomeByCompany(companyid);
		return allcompanyincome;

	}
	
	
	@GetMapping("/allincomecustomer/{customerid}")
	public List<Income> viewIncomeByCustomerId(@PathVariable("customerid") int customerid) throws Exception {
		List<Income> allcustomerincome = incomeService.viewIncomeByCustomer(customerid);
		return allcustomerincome;

	}

	@GetMapping("/viewallincome")
	public ResponseEntity<List<Income>> viewAllIncome() throws Exception {
		try {
			if (incomeService.allIncome() != null) {
				ResponseEntity<List<Income>> result = new ResponseEntity<List<Income>>(incomeService.allIncome(),
						HttpStatus.OK);
				return result;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

}
