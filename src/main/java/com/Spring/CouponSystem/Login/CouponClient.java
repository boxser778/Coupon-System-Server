package com.Spring.CouponSystem.Login;

import javax.security.auth.login.LoginException;

public interface CouponClient {

	public CouponClient login(String name,String password,ClientType clientType) throws LoginException,Exception;
	
}