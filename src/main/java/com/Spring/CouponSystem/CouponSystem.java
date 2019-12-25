package com.Spring.CouponSystem;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.CouponSystem.Beans.LoginUser;
import com.Spring.CouponSystem.Beans.Services.AdminService;
import com.Spring.CouponSystem.Beans.Services.CompanyService;
import com.Spring.CouponSystem.Beans.Services.CustomerService;

@Service
public class CouponSystem {

	@Autowired
	private AdminService adminService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CouponThread couponThread;

	@PostConstruct
	public void init() {
		couponThread.startThread();
	}

	@PreDestroy
	public void destroy() {
		couponThread.stopThread();
	}

	public LoginUser login(LoginUser loginUser) {
		switch (loginUser.getClientType()) {
		case ADMIN:
			return adminService.login(loginUser.getUsername(), loginUser.getPassword(), loginUser.getClientType());
		case COMPANY:
			return companyService.login(loginUser.getUsername(), loginUser.getPassword(), loginUser.getClientType());
		case CUSTOMER:
			return customerService.Login(loginUser.getUsername(), loginUser.getPassword(), loginUser.getClientType());
		default:
			return null;
		}
	}

}