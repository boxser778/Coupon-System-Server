package com.Spring.CouponSystem.Beans.Services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Income;
import com.Spring.CouponSystem.Beans.LoginUser;
import com.Spring.CouponSystem.Beans.Enum.ClientType;
import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.Spring.CouponSystem.Beans.Enum.IncomeType;
import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Beans.Repository.CustomerRepo;
import com.Spring.CouponSystem.Beans.Repository.IncomeRepo;

@Service
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CouponRepo couponRepo;

	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	IncomeRepo incomeRepo;

	private Customer customer;

	public Customer findCustomerByNameAndPassword(String name, String password) {
		return customerRepo.findByCustomerNameAndPassword(name, password);
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean checkIfCustomerExists(int id) {
		if (customerRepo.findById(id) != null) {
			return true;
		}
		return false;
	}

	public boolean checkIfCouponExists(int customerid, int couponid) {
		if (couponRepo.findOneCustomerCoupon(customerid, couponid) != null) {
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

	public Customer purchaseCoupon(Coupon coupon, int customerId) throws Exception {
		if (checkIfCustomerExists(customerId)) {
			Coupon getCouponById = couponRepo.findById(coupon.getid());
			customerRepo.findByCouponId(coupon.getid());
			if (checkIfCouponExists(customerId, coupon.getid())) {
				throw new Exception("this customer allready got this coupon");
			}
			if (checkCouponAmount(getCouponById)) {
				throw new Exception("out of stock");
			}
			if (checkIfCouponExpired(getCouponById)) {
				throw new Exception("this coupon is Expired");
			}

			else {
				Coupon newCoupon = couponRepo.findById(coupon.getid());
				Customer customer = customerRepo.findById(customerId);
				customer.getCoupons().add(getCouponById);
				customerRepo.save(customer);
				newCoupon.setAmount(newCoupon.getAmount() - 1);

				Income income = new Income();
				income.setCustomerid(customerId);
				Coupon couponPricetmp = couponRepo.findById(customerId);
				income.setPrice(couponPricetmp.getPrice());
				income.setDescription(IncomeType.CUSTOMER_PURCHASE);
				LocalDate localDate = LocalDate.now();
				Date date = java.sql.Date.valueOf(localDate);
				income.setDate(date);
				income.setName(customer.getCustomerName());
				incomeRepo.save(income);

			}
		}
		return customer;
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

	public Coupon getOneCoupon(int companyid, int couponid) {
		return couponRepo.findOneCoupon(companyid, couponid);

	}
	
	public Coupon getOneCouponFromAllCoupons(int couponid) {
		return couponRepo.findById(couponid);
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

	public LoginUser Login(String customerName, String password, ClientType type) {
		if (!customerName.isEmpty()) {
			Customer c = customerRepo.findByCustomerNameAndPassword(customerName, password);
			if (c != null) {
				System.out.println("Login Succes!");
				return new LoginUser(c.getId(), c.getCustomerName(), ClientType.CUSTOMER);
			} else {
				System.err.println("Login Faild!");
			}
		}

		return null;

	}
	
	public Company findById(int id) {
		return companyRepo.findById(id);
	}


}
