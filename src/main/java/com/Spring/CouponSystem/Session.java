package com.Spring.CouponSystem;
import org.springframework.stereotype.Component;

import com.Spring.CouponSystem.Login.CouponClient;

@Component
public class Session {

	private CouponClient facade;
	private long lastAccesed;
	
	
	public CouponClient getFacade() {
		return facade;
	}
	public void setFacade(CouponClient facade) {
		this.facade = facade;
	}
	public long getLastAccesed() {
		return lastAccesed;
	}
	public void setLastAccesed(long lastAccesed) {
		this.lastAccesed = lastAccesed;
	}
	@Override
	public String toString() {
		return "Session [facade=" + facade + ", lastAccesed=" + lastAccesed + "]";
	}
	
	
}