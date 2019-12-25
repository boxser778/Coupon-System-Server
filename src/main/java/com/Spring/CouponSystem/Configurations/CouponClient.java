package com.Spring.CouponSystem.Configurations;

import javax.security.auth.login.LoginException;

import com.Spring.CouponSystem.Beans.Enum.ClientType;

public interface CouponClient {

	public CouponClient login(String name,String password,ClientType clientType) throws LoginException,Exception;

	
}