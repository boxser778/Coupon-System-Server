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

import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Income;
import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.Spring.CouponSystem.Beans.Enum.IncomeType;
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

	private Customer customer;

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean checkIfCouponExists(int id) {
		if (couponRepo.findById(id) != null) {
			return true;
		}
		return false;
	}

//	public Customer purchaseCoupon(Customer customer, int couponId) throws Exception {
//		customer.setCoupons(couponRepo.findById(couponId));
//		if (checkIfCouponExists(couponId)) {
//			customerRepo.save(customer);
//			}else {
//				throw new Exception("This Company is not exists");
//			}
//				
//
//			return customer;
//	}
	
	
	


//	public List<Coupon> getAllCustomerCoupons(long customer_id) throws Exception {
//		Customer customer = customerRepo.getOne(customer_id);
//		if (customer != null) {
//			List<Coupon> coupons = customer.getCoupons();
//			if (coupons != null) {
//				return coupons;
//			} else {
//				throw new Exception("This customer doesn't have any coupons");
//			}
//		} else {
//			throw new Exception("This customer doesn't exist");
//		}
//	}
//	

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
		// TODO Auto-generated method stub
		return new CustomerService();
	}

}

//	public List<Coupon> getAllCustomerCoupons(long customer_id) throws Exception {
//		Customer customer = customerRepo.getOne(customer_id);
//		if (customer != null) {
//			List<Coupon> coupons = customer.getCoupons();
//			if (coupons != null) {
//				return coupons;
//			} else {
//				throw new Exception("This customer doesn't have any coupons");
//			}
//		} else {
//			throw new Exception("This customer doesn't exist");
//		}
//	}
//
//	public List<Coupon> getCouponsByCouponType(CouponType couponType) throws Exception {
//		List<Coupon> allCustomercoupons = getAllCustomerCoupons(this.customer.getId());
//		List<Coupon> couponsByType = couponRepository.findByType(couponType);
//		try {
//			for (Coupon coupon : allCustomercoupons) {
//				if (coupon.getType().equals(couponsByType)) {
//					couponsByType.add(coupon);
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("Failed to get all coupons by type " + e.getMessage());
//		}
//		return couponsByType;
//	}
//
//	public List<Coupon> getCouponsByPrice(double price) throws Exception {
//		List<Coupon> allCustomerCoupons = getAllCustomerCoupons(this.customer.getId());
//		List<Coupon> couponsByPrice = couponRepository.findByPriceLessThan(price);
//		try {
//			for (Coupon coupon : allCustomerCoupons) {
//				if (coupon.getPrice() <= price) {
//					couponsByPrice.add(coupon);
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("Failed to get all coupons by price " + e.getMessage());
//		}
//		return couponsByPrice;
//	}
//
//	
//}

//	public Customer findCustomerByNameAndPassword(String name, String password) {
//		return customerRepo.findCustomerByNameAndPassword(name, password);
//	}
//	
//	public Coupon getCouponById(Customer customer, int id) {
//		return couponRepo.findById(id);
//	}
//	
//	public Set<Coupon> getAllCoupons(Customer customer) {
//		return customerRepo.getAllCustomerCoupons(customer.getId());
//	}
//	
//	public Set<Coupon> getCouponsByPrice(Customer customer, double price) {
//		return customerRepo.getAllCustomerCouponsbyPrice(customer.getId(), price);
//	}
//	
//	public Set<Coupon> getCouponsByDate(Customer customer, Long endDate) {
//		return customerRepo.getAllCustomerCouponsbyDate(customer.getId(), endDate);
//	}
//	
//	public Set<Coupon> getCouponsByType(Customer customer, CouponType type) {
//		return customerRepo.getAllCustomerCouponsByType(customer.getId(), type);
//	}
//	
//	public void purchaseCoupons(Set<Integer> couponIds, int cust_id) {
//		Customer customer = customerRepo.findById(cust_id);
//		if (customer != null) {
//			Set<Coupon> uniqueCoupons = new HashSet<>();
//			for (int coup_id : couponIds) {
//				if (customerRepo.getCustomerCouponById(cust_id, coup_id) == null) {
//					Coupon coupon = couponRepo.findById(coup_id);
//					if (coupon != null && 0 < ((Coupon) coupon).getAmount()) {
//						uniqueCoupons.add((Coupon) coupon);
//						((Coupon) coupon).setAmount(((Coupon) coupon).getAmount() - 1);
//						couponRepo.save(coupon);
//					}
//				}
//			}

//			
//			uniqueCoupons.addAll(customerRepo.getAllCustomerCoupons(cust_id));
//			// TODO Save coupons without bringing all coupons back
//			((Customer) customer).setCoupons(uniqueCoupons);
//			customerRepo.save(customer);
//			
//		}
//	}


















//
//
//
//
//public void setCustomer(Customer customer) {
//	this.customer = customer;
//}
//
//@Override
//public Customer purchaseCoupon(long couponId) throws CouponNotAvailableException {
//
//	try {
//		if (!couponRepository.existsById(couponId)) {
//			throw new CouponNotAvailableException("This coupon doesn't exist, please try another one !");
//		}
//
//		Coupon coupon = couponRepository.findById((long) couponId).get();
//
//		if (coupon.getAmount() <= 0) {
//			throw new CouponNotAvailableException("This coupon is out of stock !!");
//		}
//
//		if (coupon.getEndDate().getTime() <= coupon.getStartDate().getTime()) {
//			throw new CouponNotAvailableException("This coupon has been expired");
//		}
//		
//		List<Coupon> coupons = getAllCustomerCoupons(this.customer.getId());
//		Iterator<Coupon> iterator = coupons.iterator();
//		while(iterator.hasNext()) {
//			Coupon current = iterator.next();
//			if (current.getId()==couponId) {
//				throw new CouponNotAvailableException("This coupon cannot be purchased again");
//			}
//		}
//
//		couponRepository.save(coupon);
//		Customer customer = customerRepository.findById(this.customer.getId()).get();
//		customer.getCoupons().add(coupon);
//		customerRepository.save(customer);
//		coupon.setAmount(coupon.getAmount() - 1);
//
//		Income income = new Income();
//		income.setClientId(this.customer.getId());
//		income.setAmount(coupon.getPrice());
//		income.setDate((Date) DateUtils.getCurrentDate());
//		income.setDescription(IncomeType.CUSTOMER_PURCHASE);
//		income.setName("customer " + customer.getCustomerName());
//		incomeService.storeIncome(income);
//
//	} catch (Exception e) {
//		System.out.println(e.getMessage());
//	}
//	return customer;
//}
//
//@Override
//public List<Coupon> getAllCustomerCoupons(long customer_id) throws Exception {
//	Customer customer = customerRepository.getOne(customer_id);
//	if (customer != null) {
//		List<Coupon> coupons = customer.getCoupons();
//		if (coupons != null) {
//			return coupons;
//		} else {
//			throw new CouponNotAvailableException("This customer doesn't have any coupons");
//		}
//	} else {
//		throw new Exception("This customer doesn't exist");
//	}
//}
//
//@Override
//public List<Coupon> getCouponsByCouponType(CouponType couponType) throws Exception {
//	List<Coupon> allCustomercoupons = getAllCustomerCoupons(this.customer.getId());
//	List<Coupon> couponsByType = couponRepository.findByType(couponType);
//	try {
//		for (Coupon coupon : allCustomercoupons) {
//			if (coupon.getType().equals(couponsByType)) {
//				couponsByType.add(coupon);
//			}
//		}
//	} catch (Exception e) {
//		System.out.println("Failed to get all coupons by type " + e.getMessage());
//	}
//	return couponsByType;
//}
//
//@Override
//public List<Coupon> getCouponsByPrice(double price) throws Exception {
//	List<Coupon> allCustomerCoupons = getAllCustomerCoupons(this.customer.getId());
//	List<Coupon> couponsByPrice = couponRepository.findByPriceLessThan(price);
//	try {
//		for (Coupon coupon : allCustomerCoupons) {
//			if (coupon.getPrice() <= price) {
//				couponsByPrice.add(coupon);
//			}
//		}
//	} catch (Exception e) {
//		System.out.println("Failed to get all coupons by price " + e.getMessage());
//	}
//	return couponsByPrice;
//}
//
//@Override
//public CouponClientFacade login(String name, String password, ClientType clientType) {
//	// TODO Auto-generated method stub
//	return null;
//}
//}

















