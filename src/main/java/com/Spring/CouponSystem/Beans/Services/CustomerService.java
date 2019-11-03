package com.Spring.CouponSystem.Beans.Services;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Income;
import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.Spring.CouponSystem.Beans.Enum.IncomeType;
import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Beans.Repository.CustomerRepo;
import com.Spring.CouponSystem.Login.ClientType;
import com.Spring.CouponSystem.Login.CouponClient;

@Service
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CustomerService implements CouponClient {

	@Autowired
	private IncomeService incomeService;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CouponRepo couponRepo;

	@Autowired
	CompanyRepo companyRepo;

	private Customer customer;

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean checkIfCustomerExists(int id) {
		if (customerRepo.findById(id) != null) {
			return true;
		}
		return false;
	}

	public boolean checkIfCouponExists(int couponid) {
		if (couponRepo.findById(couponid) != null) {
			return true;
		}
		return false;
	}

	public boolean checkIfCouponExpired(Coupon coupon) {
		if (coupon.getEndDate().getTime() <= coupon.getStartDate().getTime()) {
			return true;
		}
		return false;
	}

	public boolean checkCouponAmount(Coupon coupon) {
		if (coupon.getAmount() <= 0) {
			return true;
		}
		return false;
	}

//	public boolean checkIfCustomerCouponExists(Coupon coupon) throws Exception {
//		List<Coupon> coupons = customerRepo.findAllCustomerCoupons(customer.getId());
//		for (Coupon coupontmp : coupons) {
//			if (coupontmp.getid() == coupon.getid()) {
//				return true;
//			}
//
//		}
//		return false;
//
//	}

	public Customer purchaseCoupon(Coupon coupon, int customerId) throws Exception {
		if (checkIfCustomerExists(customerId)) {
			Coupon getCouponById = couponRepo.findById(coupon.getid());
			getCouponById.setCustomer(customerRepo.findById(customerId));
//			if (checkIfCustomerCouponExists(getCouponById)) {
//				throw new Exception("YOU GOT THIS COUPON ALLREADY");
//			}
			if (checkCouponAmount(getCouponById)) {
				throw new Exception("out of stock");
			}
			if (checkIfCouponExpired(getCouponById)) {
				throw new Exception("this coupon is Expired");
			}

			else {
				couponRepo.save(getCouponById);
			}
		}
		return null;
	}

	public List<Coupon> getAllCustomerCoupons(int customerid) throws Exception {
		Customer customer = customerRepo.findById(customerid);
		if (customer != null) {
			List<Coupon> coupons = customer.getCoupons();
			if (coupons != null) {
				return coupons;
			} else {
				throw new Exception("This customer doesn't have any coupons");
			}
		} else {
			throw new Exception("This customer doesn't exist");
		}
	}

	public List<Coupon> getCouponsByType(int customerid, CouponType type) {
		return couponRepo.findCustomerCouponByType(customerid, type);
	}

	public List<Coupon> getCouponsByPrice(int customerid, double price) {
		return couponRepo.findCustomerCouponByPrice(customerid, price);
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public void deleteCustomer(Long id) {
		customerRepo.deleteById(id);
	}

	public Customer findCustomerById(int id) {
		return customerRepo.findById(id);
	}

	@Override
	public CouponClient login(String name, String password, ClientType clientType) throws LoginException, Exception {
		return new CustomerService();
	}

}
