package com.Spring.CouponSystem.Beans.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.CouponSystem.Beans.Income;
import com.Spring.CouponSystem.Beans.LoginUser;
import com.Spring.CouponSystem.Beans.Repository.IncomeRepo;

@Service

public class IncomeService {

	@Autowired
	private IncomeRepo incomeRepo;

	public Income storeIncome(Income income) {
		incomeRepo.save(income);
		return income;
	}

	public List<Income> allIncome() {
		return incomeRepo.findAll();
	}

	@SuppressWarnings("static-access")
	public List<Income> viewIncomeByCompany(int companyid) throws Exception {
		LoginUser loginUser = new LoginUser();
		if (loginUser.getClientType().COMPANY != null) {
			List<Income> allIncomesByCompany = incomeRepo.findByCompanyid(companyid);
			return allIncomesByCompany;
		} else {

			throw new Exception();
		}

	}
	
	@SuppressWarnings("static-access")
	public List<Income> viewIncomeByCustomer(int customerid) throws Exception {
		LoginUser loginUser = new LoginUser();
		if (loginUser.getClientType().CUSTOMER != null) {
			List<Income> allIncomesByCustomer = incomeRepo.findBycustomerid(customerid);
			return allIncomesByCustomer;
		} else {

			throw new Exception();
		}

	}



	
}
