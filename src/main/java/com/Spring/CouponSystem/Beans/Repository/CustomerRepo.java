package com.Spring.CouponSystem.Beans.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Customer;
import com.Spring.CouponSystem.Beans.Enum.CouponType;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

	@Query("Select c from Customer c where c.id = :id")
	Customer findById(int id);
//
//	Customer findCustomerByNameAndPassword(String name, String password);
//
//	Set<Coupon> getAllCustomerCoupons(long id);
//
//	Set<Coupon> getAllCustomerCouponsbyPrice(long id, double price);
//
//	Set<Coupon> getAllCustomerCouponsbyDate(long id, Long endDate);
//
//	Set<Coupon> getAllCustomerCouponsByType(long id, CouponType type);
//
//	Object getCustomerCouponById(long cust_id, int coup_id);

	@Query("Select c from Customer c where c.customerName = :customer_Name")
	Customer findCustomerByCustName(String customer_Name);

//	@Query("Select c from Customer c where c.customerName = :user AND c.customerPassword = :password")
//	Customer findCustomerByNameAndPassword(String user, String password);

//	Set<Coupon> getAllCustomerCoupons(int id);

//	Set<Coupon> getAllCustomerCouponsbyPrice(int id, double price);

//	Set<Coupon> getAllCustomerCouponsbyDate(int id, Long endDate);

//	Set<Coupon> getCustomerCouponById(int cust_id, int coup_id);

//	Set<Coupon> getAllCustomerCouponsByType(int id, CouponType type);

	@Query("select c from Customer c where c.customerName = :name And c.customerPassword = :password")
	Customer findByCustomerNameAndPassword(String name, String password);
	
//	Customer findCustomerByNameAndPassword(String user, String password);

//	@Query("SELECT coup FROM Coupon coup WHERE coup.id IN (SELECT coup.id FROM coup.customers cust WHERE cust.id=?1 AND coup.id = ?2)")
//	Coupon getCustomerCouponById(int cust_id, int coup_id);
//	
//	@Query("SELECT coup FROM Coupon coup WHERE coup.id IN (SELECT coup.id FROM coup.customers cust WHERE cust.id=?1)")
//	Set<Coupon> getAllCustomerCoupons(int cust_id);
//	
//	@Query("SELECT coup FROM Coupon coup WHERE coup.price < ?2 AND coup.id IN (SELECT coup.id FROM coup.customers cust WHERE cust.id=?1)")
//	Set<Coupon> getAllCustomerCouponsbyPrice(int cust_id, double price);
//	
//	@Query("SELECT coup FROM Coupon coup WHERE coup.endDate < ?2 AND coup.id IN (SELECT coup.id FROM coup.customers cust WHERE cust.id=?1)")
//	Set<Coupon> getAllCustomerCouponsbyDate(int cust_id, long endDate);
//	
//	@Query("SELECT coup FROM Coupon coup WHERE type = ?2 AND coup.id IN (SELECT coup.id FROM coup.customers cust WHERE cust.id=?1)")
//	Set<Coupon> getAllCustomerCouponsByType(int cust_id, CouponType type);
//
//	Customer findCustomerByName(String custName);
//
//	Customer findCustomerByIdAndName(long id, String customerName);

	
}
