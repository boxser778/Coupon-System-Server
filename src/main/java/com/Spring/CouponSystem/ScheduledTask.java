package com.Spring.CouponSystem;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.Spring.CouponSystem.Beans.Repository.CouponRepo;


@Component
public class ScheduledTask {
	
	@Autowired
	private CouponRepo couponRepo;
	
	public void removeExpiredCoupons(Date date) {
		couponRepo.deleteAll(couponRepo.findByEndDateBefore(date));
}

	@Scheduled(fixedRate=1000 * 60 * 60 * 24)
	public void MyTask() {
		removeExpiredCoupons(new Date(System.currentTimeMillis()));
	}

	}