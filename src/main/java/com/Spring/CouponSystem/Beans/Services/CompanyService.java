package com.Spring.CouponSystem.Beans.Services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Income;
import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.Spring.CouponSystem.Beans.Enum.IncomeType;
import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Beans.Repository.IncomeRepo;
import com.Spring.CouponSystem.Login.ClientType;
import com.Spring.CouponSystem.Login.CouponClient;

@Service
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CompanyService implements CouponClient {

	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	CouponRepo couponRepo;

	@Autowired
	IncomeRepo incomeRepo;

	private Company company;

	public Company findById(int id) {
		return companyRepo.findById(id);
	}

	public boolean checkIfTitleAlreadyExists(String title) {
		if (couponRepo.findByTitle(title) != null) {
			return true;
		}
		return false;
	}

	public boolean checkIfCompanyExists(int id) {
		if (companyRepo.findById(id) != null) {
			return true;
		}
		return false;
	}

	public Coupon createCoupon(Coupon coupon, int companyId) throws Exception {
		if (checkIfTitleAlreadyExists(coupon.getTitle()) == false) {
			coupon.setCompany(companyRepo.findById(companyId));
			if (checkIfCompanyExists(companyId)) {
				LocalDate couponCreatingDate = LocalDate.now();
				Date couponDate = java.sql.Date.valueOf(couponCreatingDate);
				coupon.setStartDate(couponDate);
				couponRepo.save(coupon);

				Income income = new Income();
//				income.setClientId(companyId);
				income.setPrice(100.0);
				income.setDescription(IncomeType.COMPANY_NEW_COUPON);
				LocalDate localDate = LocalDate.now();
				Date date = java.sql.Date.valueOf(localDate);
				income.setDate(date);
				income.setName(coupon.getCompany().getComp_Name());
				incomeRepo.save(income);
			} else {
				throw new Exception("This Company is not exists");
			}

		} else {
			throw new Exception("The title " + coupon.getTitle() + " already exist, please try another title");
		}
		return coupon;
	}

	public Coupon updateCoupon(Coupon coupon) {
		Coupon currentCoupon = couponRepo.findById(coupon.getid());
		currentCoupon.setEndDate(coupon.getEndDate());
		currentCoupon.setPrice(coupon.getPrice());
		couponRepo.saveAndFlush(currentCoupon);

		Income income = new Income();
//		income.setClientId(this.company.getId());
		income.setPrice(10.0);
		income.setDescription(IncomeType.COMPANY_UPDATE_COUPON);
		LocalDate localDate = LocalDate.now();
		Date date = java.sql.Date.valueOf(localDate);
		income.setDate(date);
		income.setName("Company " + company.getComp_Name());
		incomeRepo.save(income);

		return currentCoupon;

	}

//	public boolean deleteCoupon(Coupon coupon) {
//		if (true) {
//			couponRepo.delete(coupon);
//		}
//		return false;
//	}

	public boolean deleteCoupon(int id) {
		if (true) {
			couponRepo.deleteById(id);
		}
		return false;
	}

	public Coupon findOneCoupon(int companyid, int couponid) {
		return couponRepo.findOneCoupon(companyid, couponid);
	}

	public List<Coupon> getAllCompanyCoupons(int company_id) throws Exception {
		Company company = companyRepo.getOne(company_id);
		if (company != null) {
			List<Coupon> coupons = company.getCoupons();
			return coupons;
		} else {
			throw new Exception("This company doesn't exist");
		}

	}

	public void saveCompany(Company company) {
		companyRepo.save(company);
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Coupon> findAllCoupons() {
		return couponRepo.findAll();
	}

	public List<Coupon> getCouponsByEndDate(int companyid, Date endDate) {
		return couponRepo.findCompanyCouponByEndDate(companyid, endDate);
	}

	public List<Coupon> getCouponsByPrice(int companyid, double price) {
		return couponRepo.findCompanyCouponByPrice(companyid, price);
	}

	public List<Coupon> getCouponsByType(int companyid, CouponType type) {
		return couponRepo.findCompanyCouponByType(companyid, type);
	}

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@Override
	public CouponClient login(String name, String password, ClientType clientType) throws LoginException, Exception {

		return new CompanyService();
	}

}
