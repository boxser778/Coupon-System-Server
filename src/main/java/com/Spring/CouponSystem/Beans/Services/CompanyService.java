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
	
//	public void updateExistingCoupon(Company company, Coupon coupon) {
//		coupon.setCompany(company);
//		couponRepo.save(coupon);
//	}
	
//	public Set<Coupon> getCoupons(Company company) {
//		return companyRepo.findCompanyCoupons(company);
//	}
	
//	public Coupon getCouponById(Company company, long id) {
//		return companyRepo.findCompanyCouponById(id, company);
//	}
	
//	public Set<Coupon> getCouponsByPrice(Company company, double price) {
//		return companyRepo.findCompanyCouponsByPrice(price, company);
//	}
	
	public List<Coupon> getCouponsByEndDate(Date endDate) {
		return companyRepo.findCompanyCouponsByDate(endDate);
	}



	public void saveCompany(Company company) {
		companyRepo.save(company);
	}



	public void setCompany(Company company) {
	}



	@Override
	public CouponClient login(String name, String password, ClientType clientType) throws LoginException, Exception {
	
		return new CompanyService();
	}
	
//	public Set<Coupon> getCouponsByType(Company company, CouponType type) {
//		return companyRepo.findCompanyCouponsByType(type, company);
//	}
	
	
	
	
	
	
	
//	@Autowired
//	private CompanyRepository companyRepository;
//
//	@Autowired
//	private CouponRepository couponRepository;
//
//	@Autowired
//	private CustomerRepository customerRepository;
//
//	@Autowired
//	private CustomerServiceImpl customerServiceImpl;
//
//	@Autowired
//	private IncomeRepository incomeRepository;
//
//	private Customer customer;
//
//	private Company company;
//
//	@Override
//	public void setCompany(Company company) {
//		this.company = company;
//	}
//
//	// @Override
//	// public List<Company> findAll(){
//	// return companyRepository.findAll();
//	// }
//
//	@Override
//	public boolean checkIfTitleAlreadyExists(String title) {
//		if (couponRepository.findByTitle(title) != null) {
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public Coupon createCoupon(Coupon coupon) throws Exception {
//		if (checkIfTitleAlreadyExists(coupon.getTitle()) == false) {
//			couponRepository.save(coupon);
//			Company comp = companyRepository.findById(this.company.getId()).get();
//			comp.getCoupons().add(coupon);
//			companyRepository.save(comp);
//			Income income = new Income();
//			income.setClientId(this.company.getId());
//			income.setAmount(100.0);
//			income.setDescription(IncomeType.COMPANY_NEW_COUPON);
//			income.setDate((Date) DateUtils.getCurrentDate());
//			income.setName("Company " + company.getCompanyName());
//			incomeRepository.save(income);
//			
//		} else {
//			throw new Exception("The title " + coupon.getTitle() + " already exist, please try another title");
//		}
//		return coupon;
//	}
//
//	@Override
//	public void updateCoupon(Coupon coupon, Date endDate, double price) {
//		coupon.setEndDate(endDate);
//		coupon.setPrice(price);
//		couponRepository.save(coupon);
//		Income income = new Income();
//		income.setClientId(this.company.getId());
//		income.setAmount(10.0);
//		income.setDescription(IncomeType.COMPANY_UPDATE_COUPON);
//		income.setDate((Date) DateUtils.getCurrentDate());
//		income.setName("Company " + company.getCompanyName());
//		incomeRepository.save(income);
//	}
//	
//	
//	
//	@Override
//	public void deleteCoupon(long coupon_id) throws Exception {
////		if (!couponRepository.existsById(couponId)) {
////			throw new CouponNotAvailableException("This coupon id doesn't exist in DataBase");
////		}
//		
////		List<Coupon> coupons = getAllCompanyCoupons(this.company.getId());
////		Coupon coupon = couponRepository.findById(coupon_id).get();
////		coupons.remove(coupon);
////		this.company.setCoupons(coupons);
//////		couponRepository.delete(coupon);
////		customerServiceImpl.deleteCoupon(coupon_id);
//
//		
//		Coupon coupon2 = couponRepository.getOne(coupon_id);
//		if (coupon2!=null) {
//			couponRepository.delete(coupon2);
//		}else {
//			throw new CouponNotAvailableException("This coupon id doesn't exist in DataBase");
//
//		}
//
//	}
//
//	@Override
//	public Company companyById(long id) {
//		return companyRepository.findById(id).get();
//	}
//
//	@Override
//	public List<Coupon> getAllCompanyCoupons(long company_id) throws Exception {
//		Company company = companyRepository.getOne(company_id);
//		if (company != null) {
//			List<Coupon> coupons = company.getCoupons();
//			if (coupons != null) {
//				return coupons;
//			} else {
//				throw new CouponNotAvailableException("This company doesn't have any coupons");
//			}
//		} else {
//			throw new Exception("This company doesn't exist");
//		}
//	}
//
//	@Override
//	public List<Coupon> getCouponsByCouponType(CouponType couponType) throws Exception {
//		List<Coupon> allCompanycoupons = getAllCompanyCoupons(this.company.getId());
//		List<Coupon> couponsByType = couponRepository.findByType(couponType);
//		try {
//			for (Coupon coupon : allCompanycoupons) {
//				if (coupon.getType().equals(couponsByType)) {
//					couponsByType.add(coupon);
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("Failed to get all coupons by type " + e.getMessage());
//		}
//		return couponsByType;
//	}
//
//	@Override
//	public List<Coupon> getCouponsByPrice(double price) throws Exception {
//		List<Coupon> allCompanyCoupons = getAllCompanyCoupons(this.company.getId());
//		List<Coupon> couponsByPrice = couponRepository.findByPriceLessThan(price);
//		try {
//			for (Coupon coupon : allCompanyCoupons) {
//				if (coupon.getPrice() <= price) {
//					couponsByPrice.add(coupon);
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("Failed to get all coupons by price " + e.getMessage());
//		}
//		return couponsByPrice;
//	}
//
//	@Override
//	public List<Coupon> getCouponsByEndDate(Date endDate) throws Exception {
//		List<Coupon> allCompanyCoupons = getAllCompanyCoupons(this.company.getId());
//		List<Coupon> couponsByDate = couponRepository.findByEndDateBefore(endDate);
//		try {
//			for (Coupon coupon : allCompanyCoupons) {
//				if (coupon.getEndDate().equals(endDate) || coupon.getEndDate().before(endDate)) {
//					couponsByDate.add(coupon);
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("Failed to get all coupons by date " + e.getMessage());
//		}
//		return couponsByDate;
//	}
//
//	@Override
//	public CouponClientFacade login(String name, String password, ClientType clientType) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}