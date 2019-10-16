package com.Spring.CouponSystem.Beans.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Enum.CouponType;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Long>{

	@Query("Select c from Coupon c where c.id = :id")
	Coupon findById(int id);
	
//	@Query("Select c from Coupon c where c.title = :title")
//	Coupon findByTitle(String title);
	
	@Query("Select c from Coupon c where c.type = :type")
	List<Coupon> findByType(String type);
	
//	@Query("Select c from Coupon c where c.title = :title")
//	Coupon findByName(String title);
	
//	@Query("select c from Coupon c where c.title = :title")
//	Coupon findByTitle(String title);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Coupon c WHERE c.id = :id")
	void removeCoupon(@Param("id") int id);
	
//	long deleteById(int id);
	
//	@Query("select c from Coupon c where c.id = ?1 AND c.amount > 0")
//	Coupon findCouponWithValidAmount(int id);
//	
//	Coupon findCouponByTitle(String title);
//	
//	@Query("select c from Coupon c where  0 < c.amount AND ?1 < c.endDate ")
//	Set<Coupon> findPurchableCouponByAmountAndEndDate(Long endDate);

//	public List<Coupon> findById(Long Id);
//	
//	public List<Coupon> findByTitle(String Title);
//	
	public List<Coupon> findByEndDate(Date endDate);
//	
//	public List<Coupon> findByCouponType(CouponType Type);
//	
//	public List<Coupon> findByPrice(Double Price);

	@Query("Select c from Coupon c where c.title = :title")
	Coupon findCouponByTitle(String title);

//	@Query("PUT Coupon set amount =:amount where c.id = :id")
//	UPDATE Admin SET firstname = :firstname, lastname = :lastname WHERE id = :id
//	update User u set u.status = :status where u.name = :name
//	public Coupon updateCoupon(long id , Coupon c);
}

