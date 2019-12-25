package com.Spring.CouponSystem.Beans.Services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Spring.CouponSystem.Beans.Income;
import com.Spring.CouponSystem.Beans.LoginUser;
import com.Spring.CouponSystem.Beans.Repository.IncomeRepo;

@Service
@CrossOrigin()
public class IncomeService {

	@Autowired
	private IncomeRepo incomeRepo;

	public LoginUser getLoggedUser(HttpServletRequest req) {
		System.out.println("inside customer controller" + req.getSession().getAttribute("user"));
		return (LoginUser) req.getSession(false).getAttribute("user");

	}

	public Income storeIncome(Income income) {
		incomeRepo.save(income);
		return income;
	}

	public List<Income> allIncome() {
		return incomeRepo.findAll();
	}

//	public List<Income> viewIncomeByCustomerName(String name) throws Exception {
//		try {
//			return incomeRepo.findAllIncomeByName(name);
//		} catch (Exception e) {
//			throw new Exception("Fialed to Get all incomes by customer ");
//		}
//	}

//	public List<Income> viewIncomeByDescription(int id,IncomeType description) throws Exception {
//		try {
//			return incomeRepo.findAllIncomeByDescription(id,description);
//
//		} catch (Exception e) {
//			throw new Exception("Ftialed to Ge all incomes by company ");
//		}
//	}

//	public List<Income> allIncome(){
//		return incomeRepo.findAll();
//	}
//	
//
//	public List<Income> viewIncomeByCustomer(int customerId) throws Exception{
//		try {
//			List<Income> allIncomesByCustomer = incomeRepo.findAllByClientId(customerId);
//			return allIncomesByCustomer;
//		} catch (Exception e) {
//			throw new Exception("Fialed to Get all incomes by customer " + customerId);
//		}
//	}
//	
//	public List<Income> viewIncomeByCompany(int companyId) throws Exception{
//		try {
//			List<Income> allIncomesByCompany = incomeRepo.findAllByClientId(companyId);
//			return allIncomesByCompany;
//		} catch (Exception e) {
//			throw new Exception("Fialed to Get all incomes by company " + companyId);
//		}
//	}
//	

}
