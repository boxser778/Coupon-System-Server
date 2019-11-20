package com.Spring.CouponSystem;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Repository.CustomerRepo;
import com.Spring.CouponSystem.Beans.Services.AdminService;
import com.Spring.CouponSystem.Beans.Services.CompanyService;
import com.Spring.CouponSystem.Beans.Services.CustomerService;
import com.Spring.CouponSystem.Login.ClientType;
import com.Spring.CouponSystem.Login.CouponClient;

@Service
public class CouponSystem {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private AdminService adminService;
	@Autowired
	private CompanyService companyService;

	@Autowired
	private CompanyRepo companyRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CouponThread couponThread;

	@Autowired
	private CustomerService customerService;

	@PostConstruct
	public void init() {
		couponThread.startThread();
	}

	@PreDestroy
	public void destroy() {
		couponThread.stopThread();
	}

	public CouponClient login(String name, String password, ClientType clientType) throws Exception {
		switch (clientType) {
		case ADMIN:
			if (name.equals("admin") && password.equals("1234")) {
				adminService = context.getBean(AdminService.class);
				return (CouponClient) adminService;
			} else {
				throw new Exception("Admin failed to connect");
			}
		case COMPANY:
			Company comp = companyRepo.findByCompanyNameAndPassword(name, password);
			if (comp != null) {
				CompanyService company = context.getBean(CompanyService.class);
				company.setCompany(comp);
				return (CouponClient) company;
			} else {
				throw new Exception("Company failed to connect");
			}

		case CUSTOMER:
			Customer cust = customerRepo.findByCustomerNameAndPassword(name, password);
			if (cust != null) {
//				return { id: cust.getid(), type: ClientType.CUSTOMER };
				CustomerService customer = context.getBean(CustomerService.class);
				customer.saveCustomer(cust);
				return (CouponClient) customer;
			
			} else {
				throw new Exception("Customer failed to connect");
			}

		default:
			break;
		}
		throw new Exception("Login Falied! Invalid User or Password!");
	}
}