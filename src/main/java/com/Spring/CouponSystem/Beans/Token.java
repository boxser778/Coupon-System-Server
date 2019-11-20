package com.Spring.CouponSystem.Beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table(name = "token")
public class Token {

	@Column(nullable = false)
	@Basic(optional = false)
	private String token;

	@Column(nullable = false)
	@Basic(optional = false)
	private String clientType;
	
	

	public Token(String token, String clientType) {
		this.token = token;
		this.clientType = clientType;
	}
	
	

	public Token() {
	}



	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	@Override
	public String toString() {
		return "Token [token=" + token + ", clientType=" + clientType + "]";
	}

}