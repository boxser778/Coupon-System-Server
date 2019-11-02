package com.Spring.CouponSystem.Beans.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Beans.Repository.CustomerRepo;
import com.Spring.CouponSystem.Login.ClientType;
import com.Spring.CouponSystem.Login.CouponClient;

@Service
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AdminService implements CouponClient {

//	public boolean login(String name, String password) {
//		return (name.equals("admin") && password.equals("1234"));
//
//	}

	// @@@@@@@@@@@@@@@@@@@ Company Options @@@@@@@@@@@@@@@@@@@

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
//		currentCompany.setComp_Name(company.getComp_Name());
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

	// @@@@@@@@@@@@@@@@@@@ Customer Options @@@@@@@@@@@@@@@@@@@

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
	
	public boolean deleteCustomer(Customer customer) {
		try {
			customerRepo.delete(customer);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public List<Customer> findAllCustomers() {
		return customerRepo.findAll();
	}

	// @@@@@@@@@@@@@@@@@@@ Coupon Options @@@@@@@@@@@@@@@@@@@

	public List<Coupon> findAllCoupons() {
		return couponRepo.findAll();
	}

//	public Coupon findCoupon(int id) {
//		return couponRepo.findById(id);
//	}

	public Coupon createCoupon(Coupon coupon) {
			coupon.setid(0);
		return couponRepo.save(coupon);
	}

//	public Coupon updateCoupon(Coupon coupon) {
//		
//		Coupon currentCoupon = couponRepo.findById(coupon.getid());
//		currentCoupon.setEndDate(coupon.getEndDate());
//		currentCoupon.setPrice(coupon.getPrice());
//		return couponRepo.saveAndFlush(currentCoupon);
//		
//	}

	public boolean deleteCoupon(Coupon coupon) {
		try {
			couponRepo.delete(coupon);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public boolean isCouponTitleExist(String title) {
		Coupon coup = couponRepo.findByTitle(title);
		return coup == null;
	}

//	public Coupon updateCoupon(long id, Coupon c) {
//		try {
//			couponRepo.updateCoupon(id, c);
//			return true;
//		}catch (IllegalArgumentException e) {
//			return false;
//		}

//		return couponRepo.updateCoupon(id, c);

//	}

//	public Coupon updateCoupon(long id,Coupon coupon) {
//		if (couponRepo.findById(coupon.getId()) != null) {
//			couponRepo.save(coupon);
//			return coupon;
//		}
//		return null;
//	}

	@Override
	public CouponClient login(String name, String password, ClientType clientType) {
		// TODO Auto-generated method stub
		return new AdminService();
	}
	
}