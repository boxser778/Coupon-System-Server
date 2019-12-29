package com.Spring.CouponSystem.Beans.Services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Income;
import com.Spring.CouponSystem.Beans.LoginUser;
import com.Spring.CouponSystem.Beans.Enum.ClientType;
import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.Spring.CouponSystem.Beans.Enum.IncomeType;
import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Beans.Repository.IncomeRepo;

@Service
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CompanyService {

	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	CouponRepo couponRepo;

	@Autowired
	IncomeRepo incomeRepo;

	private Company company;

	public Company findByNameAndPassword(String compName, String password) {
		return companyRepo.findByCompanyNameAndPassword(compName, password);
	}

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
				DateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");
				timeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
				String curTime = timeFormat.format(new Date());
				coupon.setStartDate(curTime);
				couponRepo.save(coupon);

				Income income = new Income();
				income.setCompanyid(companyId);
				income.setPrice(100.0);
				income.setDescription(IncomeType.COMPANY_NEW_COUPON);
				DateFormat timeFormat2 = new SimpleDateFormat("dd-MM-yyyy");
				timeFormat2.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
				String curTime2 = timeFormat.format(new Date());
				income.setDate(curTime2);
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

	public Coupon updateCoupon(int companyid, Coupon coupon) {

		coupon.setCompany(companyRepo.findById(companyid));

		Coupon currentCoupon = couponRepo.findById(coupon.getid());
		currentCoupon.setEndDate(coupon.getEndDate());
		currentCoupon.setPrice(coupon.getPrice());
		couponRepo.saveAndFlush(currentCoupon);

		Income income = new Income();
		income.setCompanyid(companyid);
		income.setPrice(10.0);
		income.setDescription(IncomeType.COMPANY_UPDATE_COUPON);
		DateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy");
		timeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
		String curTime = timeFormat.format(new Date());
		income.setDate(curTime);
		income.setName(coupon.getCompany().getComp_Name());
		incomeRepo.save(income);
		return currentCoupon;
	}

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

	public Coupon getOneCoupon(int companyid, int couponid) {
		return couponRepo.findOneCoupon(companyid, couponid);

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

//	public List<Coupon> getCouponsByEndDate(int companyid, Date endDate) throws ParseException {
//		String time = toDate(endDate);
//		List<Coupon>coupons = couponRepo.findCompanyCouponByendDate(companyid, time);
//		return coupons;
//	}
//	
//	public List<Coupon> getCouponsByEndDate(int companyid, Date endDate) throws ParseException {
//		List<Coupon> coupons = couponRepo.findCompanyCouponByendDate(companyid, endDate);
//		return coupons;
//	}

	public List<Coupon> getCouponsByPrice(int companyid, double price) {
		return couponRepo.findCompanyCouponByPrice(companyid, price);
	}

	public List<Coupon> getCouponsByType(int companyid, CouponType type) {
		return couponRepo.findCompanyCouponByType(companyid, type);
	}

	public LoginUser login(String companyName, String password, ClientType type) {
		if (!companyName.isEmpty()) {
			Company c = companyRepo.findByCompanyNameAndPassword(companyName, password);
			if (c != null) {
				System.out.println("Login Succes!");
				return new LoginUser(c.getId(), c.getComp_Name(), ClientType.COMPANY);
			} else {
				System.err.println("Login Faild!");
			}
		}

		return null;

	}

}
