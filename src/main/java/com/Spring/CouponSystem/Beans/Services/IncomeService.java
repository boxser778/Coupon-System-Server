package com.Spring.CouponSystem.Beans.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.CouponSystem.Beans.Income;
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

	public List<Income> viewIncomeByCompany(int companyid) throws Exception {
		try {
			List<Income> allIncomesByCompany = incomeRepo.findByCompanyid(companyid);
			return allIncomesByCompany;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public List<Income> viewIncomeByCustomer(int customerid) throws Exception {
		try {
			List<Income> allIncomesByCustomer = incomeRepo.findBycustomerid(customerid);
			return allIncomesByCustomer;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
