package com.Spring.CouponSystem;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Beans.Repository.CustomerRepo;

@Component
public class CouponThread {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	CouponRepo couponRepo;

	private boolean exit = false;
	private boolean running = true;

	public void removeExpiredCoupons(Date date) {
		couponRepo.deleteAll(couponRepo.findByEndDate(date));
	}


	public void startThread() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (running) {
					removeExpiredCoupons(new Date(System.currentTimeMillis()));
					try {
						Thread.sleep(1000 * 60 * 60 * 24);
//						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println("Erorr " + e.getMessage());
					}
				}
			}
		}).start();
	}
	
	public void stopThread() {
		this.running = false;
	}

}