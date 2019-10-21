package com.Spring.CouponSystem.Beans.Services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Login.ClientType;
import com.Spring.CouponSystem.Login.CouponClient;

@Service
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CompanyService implements CouponClient {

	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	CouponRepo couponRepo;

	public Company findById(int id) {
		return companyRepo.findById(id);
	}

	public Coupon createCoupon(Coupon coupon) {
		coupon.setId(0);
		return couponRepo.save(coupon);
	}

//	public List<Coupon> getAllCompanyCoupons(long company_id) throws Exception {
//		Company company = companyRepo.getOne(company_id);
//		if (company != null) {
//			List<Coupon> coupons = company.getCoupons();
//			if (coupons != null) {
//				return coupons;
//			} else {
//				throw new Exception("This company doesn't have any coupons");
//			}
//		} else {
//			throw new Exception("This company doesn't exist");
//		}
//	}

//	public Company findByNameAndPassword(String compName, String password) {
//		return companyRepo.findCompanyByCompNameAndPassword(compName, password);
//	}

//	public boolean deleteCoupon(Company company, long id) {
//		if (companyRepo.findCompanyCouponById(id, company) != null) {
//			couponRepo.removeCoupon(id);
//			return true;
//		} else {
//			return false;
//		}
//	}

//	public long addNewCoupon(Company company, Coupon coupon) {
//		// check that the name is unique
//		if (couponRepo.findCouponByTitle(coupon.getTitle()) == null) {
//			coupon.setCompany(company);
//			coupon.setId(0);
//			couponRepo.save(coupon);
//			
//			return coupon.getId();
//		}
//		return -1;
//	}

	public Coupon findCoupon(int id) {
		return couponRepo.findById(id);
	}

	public List<Coupon> getCouponsByEndDate(Date endDate) {
		return companyRepo.findCouponsByDate(endDate);
	}

	public List<Coupon> getCouponsByPrice(double price) {
		return companyRepo.findCouponsByPrice(price);
	}

	public List<Coupon> getCouponsByType(CouponType type) {
		return companyRepo.findCouponsByType(type);
	}

	public void saveCompany(Company company) {
		companyRepo.save(company);
	}

	public void setCompany(Company company) {
	}

	public boolean isCouponTitleExist(String title) {
		Coupon coup = couponRepo.findCouponByTitle(title);
		return coup == null;
	}

	public Coupon updateCoupon(Coupon coupon) {

		Coupon currentCoupon = couponRepo.findById(coupon.getId());
		currentCoupon.setEndDate(coupon.getEndDate());
		currentCoupon.setPrice(coupon.getPrice());
		return couponRepo.saveAndFlush(currentCoupon);

	}

	public boolean deleteCoupon(Coupon coupon) {
		try {
			couponRepo.delete(coupon);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public Company findCompany(int id) {
		return companyRepo.findById(id);
	}

	public List<Coupon> findAllCoupons() {
		return couponRepo.findAll();
	}

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@Override
	public CouponClient login(String name, String password, ClientType clientType) throws LoginException, Exception {

		return new CompanyService();
	}

}
