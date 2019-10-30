package com.Spring.CouponSystem.Beans.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Enum.CouponType;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {

	@Query("Select c from Company c where c.id = :id")
	Company findById(int id);

//	Company findCompanyByCompNameAndPassword(String user, String password);

//	@Query("select c from Coupon c where c.company = ?1")
//	List<Coupon> findCompanyCoupons(Company company);
//	
//	@Query("select c from Coupon c where c.id = ?1 AND c.company = ?2")
//	Coupon findCompanyCouponById(int id, Company company);

//Company findCompanyByCompNameAndPassword(String comp_name, String password);

	@Query("Select c from Company c where c.comp_Name = :compName")
	Company findCompanyByCompName(String compName);

//	@Query("select c from Coupon c where c.company = ?1")
//	Set<Coupon> findCompanyCoupons(Company company);

//	@Query("select c from Coupon c where c.id = ?1 AND c.company = ?2")
//	Coupon findCompanyCouponById(long id, Company company);
//	
//	@Query("select c from Coupon c where c.price < ?1 AND c.company = ?2")
//	Set<Coupon> findCompanyCouponsByPrice(double price, Company company);
//	
//	@Query("select c from Coupon c where c.type = ?1 AND c.company = ?2")
//	Set<Coupon> findCompanyCouponsByType(CouponType type, Company company);
//	
	@Query("select c from Coupon c where c.endDate = :endDate")
	List<Coupon> findCouponsByDate(Date endDate);

//	@Query("Select c from Company c where c.comp_Name = :user AND c.password = :password")
//	Company findCompanyByCompNameAndPassword(String user, String password);

	@Query("select c from Company c where c.comp_Name = :name And c.password = :password")
	Company findByCompanyNameAndPassword(String name, String password);

	@Query("select c from Coupon c where c.price = :price")
	List<Coupon> findCouponsByPrice(double price);

	@Query("select c from Coupon c where c.type = :type")
	List<Coupon> findCouponsByType(CouponType type);

}
