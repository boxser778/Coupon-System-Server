package com.Spring.CouponSystem.Beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table(name = "loginuser")
public class LoginUser {

	
	@Column(nullable = false)
	@Basic(optional = false)
	private String username;
	
	@Column(nullable = false)
	@Basic(optional = false)
	private String password;
	
	@Column(nullable = false)
	@Basic(optional = false)
	private String clientType;
	
	

	public LoginUser() {
	
	}

	public LoginUser(String username, String password, String clientType) {
		this.username = username;
		this.password = password;
		this.clientType = clientType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	@Override
	public String toString() {
		return "LoginUser [username=" + username + ", password=" + password + ", clientType=" + clientType + "]";
	}
	
	
	
	
}
