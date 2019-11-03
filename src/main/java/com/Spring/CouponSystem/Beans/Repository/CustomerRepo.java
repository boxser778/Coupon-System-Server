package com.Spring.CouponSystem.Beans.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Enum.CouponType;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	@Query("Select c from Customer c where c.id = :id")
	Customer findById(int id);

	@Query("select c from Coupon c where c.type = :type")
	List<Coupon> findCouponsByType(CouponType type);

	@Query("select c from Coupon c where c.endDate = :endDate")
	List<Coupon> findCouponsByDate(Date endDate);

	@Query("Select c from Coupon c where c.id = :id")
	List<Coupon> findByCouponId(int id);

	@Query("Select c from Customer c where c.customerName = :customer_Name")
	Customer findCustomerByCustName(String customer_Name);

	@Query("select c from Customer c where c.customerName = :name And c.customerPassword = :password")
	Customer findByCustomerNameAndPassword(String name, String password);

}
