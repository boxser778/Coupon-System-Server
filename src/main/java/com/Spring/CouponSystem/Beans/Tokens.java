package com.Spring.CouponSystem.Beans;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.Spring.CouponSystem.Session;

@Component
@Table(name = "tokens")
public class Tokens {

	private @NonNull Map<String, Session> tokensMap;

	public Tokens() {
	}

	public Tokens(Map<String, Session> tokensMap) {
		this.tokensMap = tokensMap;
	}

	public Map<String, Session> getTokensMap() {
		return tokensMap;
	}

	public void setTokensMap(Map<String, Session> tokensMap) {
		this.tokensMap = tokensMap;
	}

}
