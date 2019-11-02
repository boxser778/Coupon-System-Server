package com.Spring.CouponSystem.Beans.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Enum.CouponType;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {

	@Query("Select c from Company c where c.id = :id")
	Company findById(int id);

	@Query("Select c from Company c where c.comp_Name = :compName")
	Company findCompanyByCompName(String compName);

//	@Query("SELECT company FROM COMPANY as company join company.coupons as c.id=:couponId")
//	List<Coupon> findCouponsByCompany(int  companyId);
	
	@Query("select c from Coupon c where c.endDate = :endDate")
	List<Coupon> findCouponsByDate(Date endDate);

	@Query("select c from Company c where c.comp_Name = :name And c.password = :password")
	Company findByCompanyNameAndPassword(String name, String password);

	@Query("select c from Coupon c where c.price = :price")
	List<Coupon> findCouponsByPrice(double price);

	@Query("select c from Coupon c where c.type = :type")
	List<Coupon> findCouponsByType(CouponType type);

}
