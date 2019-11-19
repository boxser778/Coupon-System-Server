package com.Spring.CouponSystem.Beans.Services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Spring.CouponSystem.Beans.Income;
import com.Spring.CouponSystem.Beans.Repository.IncomeRepo;

@Service
@CrossOrigin()
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

	public List<Income> viewIncomeByCustomerName(String name) throws Exception {
		try {
			return incomeRepo.findAllIncomeByName(name);
		} catch (Exception e) {
			throw new Exception("Fialed to Get all incomes by customer ");
		}
	}

	public List<Income> viewIncomeByCompanyName(String name) throws Exception {
		try {
			return incomeRepo.findAllIncomeByName(name);

		} catch (Exception e) {
			throw new Exception("Fialed to Get all incomes by company ");
		}
	}
}
