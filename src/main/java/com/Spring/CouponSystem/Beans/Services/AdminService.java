package com.Spring.CouponSystem.Beans.Services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.LoginUser;
import com.Spring.CouponSystem.Beans.Enum.ClientType;
import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Beans.Repository.CustomerRepo;

@Service
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AdminService {

	@Autowired
	CompanyRepo companyRepo;
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	CouponRepo couponRepo;

	public AdminService() {
	}

	public Company findCompany(int id) {
		return companyRepo.findById(id);
	}

	public boolean isCompNameExists(String compName) {
		Company comp = companyRepo.findCompanyByCompName(compName);
		return comp == null;
	}

	public Company createCompany(Company company) {
		company.setId(0);
		return companyRepo.save(company);
	}

	public Company updateCompany(Company company) {
		Company currentCompany = companyRepo.findById(company.getId());
		currentCompany.setEmail(company.getEmail());
		currentCompany.setPassword(company.getPassword());
		return companyRepo.saveAndFlush(currentCompany);
	}

	public boolean deleteCompany(Company company) {
		try {
			companyRepo.delete(company);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public List<Company> findAllCompanies() {
		return companyRepo.findAll();
	}

	public Customer findCustomer(int id) {
		return customerRepo.findById(id);
	}

	public boolean isCustNameExists(String custName) {
		Customer cust = customerRepo.findCustomerByCustName(custName);
		return cust == null;
	}

	public Customer createCustomer(Customer customer) {
		customer.setId(0);
		return customerRepo.save(customer);

	}

	public Customer updateCustomer(Customer customer) {
		Customer currentCustomer = customerRepo.findById(customer.getId());
		currentCustomer.setCustomerName(customer.getCustomerName());
		currentCustomer.setCustomerPassword(customer.getCustomerPassword());
		return customerRepo.saveAndFlush(currentCustomer);

	}

	public boolean deleteCustomer(int customerId) {
		try {
			Customer customertmp = customerRepo.findById(customerId);
			customerRepo.delete(customertmp);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public List<Customer> findAllCustomers() {
		return customerRepo.findAll();
	}

	@SuppressWarnings("static-access")
	public LoginUser login(String admin, String password, ClientType type) {
		if (admin.equals("admin") && password.equals("1234") && type.equals(type.ADMIN)) {
			return new LoginUser(admin, password, type.ADMIN);
		}
		return null;
	}

	public LoginUser getLoggedUser(HttpServletRequest req) {
		return (LoginUser) req.getSession(false).getAttribute("user");

	}

}