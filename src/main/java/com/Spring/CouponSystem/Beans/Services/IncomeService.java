package com.Spring.CouponSystem.Beans.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Spring.CouponSystem.Beans.Income;
import com.Spring.CouponSystem.Beans.Repository.IncomeRepo;

@Service
@CrossOrigin()
public class IncomeService{

	@Autowired
	private IncomeRepo incomeRepo;
	
	public Income storeIncome (Income income) {
		incomeRepo.save(income);
		return income;
	}
	
	
	public List<Income> allIncome(){
		return incomeRepo.findAll();
	}
	

	
	public Income viewIncomeByCustomerId(int id) throws Exception{
		try {
			Income allIncomesByCustomer = incomeRepo.findClientById(id);
			return allIncomesByCustomer;
		} catch (Exception e) {
			throw new Exception("Fialed to Get all incomes by customer " + id);
		}
	}
	
	
	public Income viewIncomeByCompanyId(int id) throws Exception{
		try {
			Income allIncomesByCompany = incomeRepo.findClientById(id);
			return allIncomesByCompany;
		} catch (Exception e) {
			throw new Exception("Fialed to Get all incomes by company " + id);
		}
	}
}
	