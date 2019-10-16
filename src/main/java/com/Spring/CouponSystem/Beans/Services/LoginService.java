//package com.Spring.CouponSystem.Beans.Services;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.Spring.CouponSystem.Beans.Company;
//import com.Spring.CouponSystem.Beans.Customer;
//import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
//import com.Spring.CouponSystem.Beans.Repository.CustomerRepo;
//import com.Spring.CouponSystem.Login.ClientType;
//
//@Service
//public class LoginService {
//	
//	@Autowired
//	CompanyRepo companyRepo;
//	
//	@Autowired
//	CustomerRepo customerRepo;
//	
//	public Optional<Integer> login(String user, String password, ClientType type) {
//		
//		switch (type) {
//		case ADMIN:
//			return (user.equals("admin") && password.equals("1234")) ? Optional.of(1) : Optional.empty();
//		case COMPANY:
//			Company compnay = companyRepo.findByCompanyNameAndPassword(user, password);
//			if (compnay != null) {
//				return Optional.of(compnay.getId());
//			} else {
//				return Optional.empty();
//			}
//		case CUSTOMER:
//			Customer customer = customerRepo.findByCustomerNameAndPassword(user, password);
//			if (customer != null) {
//				return Optional.of(customer.getId());
//			} else {
//				return Optional.empty();
//			}
//		default:
//			return Optional.empty();
//		}
//	}
//	
//}