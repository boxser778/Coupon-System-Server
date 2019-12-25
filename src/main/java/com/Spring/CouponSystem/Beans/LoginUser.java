package com.Spring.CouponSystem.Beans;

import com.Spring.CouponSystem.Beans.Enum.ClientType;

public class LoginUser {

	private int userId;
	private String username;
	private String password;
	private ClientType clientType;

	public LoginUser() {

	}

	public LoginUser(int userId, String username, ClientType clientType) {
		this.userId = userId;
		this.username = username;
		this.clientType = clientType;
	}

	public LoginUser(String username, String password, ClientType clientType) {
		this.username = username;
		this.password = password;
		this.clientType = clientType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void newUser(int userId) {
		this.userId = userId;
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

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

	@Override
	public String toString() {
		return "LoginUser [userId=" + userId + ", username=" + username + ", password=" + password + ", clientType="
				+ clientType + "]";
	}

}
