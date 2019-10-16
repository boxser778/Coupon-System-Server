//package com.Spring.CouponSystem.Login;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.cors.CorsConfiguration;
//
//import com.Spring.CouponSystem.Beans.Company;
//import com.Spring.CouponSystem.Beans.Customer;
//import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
//import com.Spring.CouponSystem.Beans.Repository.CustomerRepo;
//import com.Spring.CouponSystem.Beans.Services.AdminService;
//
//@Service
//@CrossOrigin()
//public class LoginService {
//	
//	@Autowired
//	CompanyRepo companyRepo;
//	
//	@Autowired
//	CustomerRepo customerRepo;
//	
//	@Autowired
//	AdminService adminService;
//	@CrossOrigin()
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
//			Customer customer = customerRepo.findCustomerByNameAndPassword(user, password);
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