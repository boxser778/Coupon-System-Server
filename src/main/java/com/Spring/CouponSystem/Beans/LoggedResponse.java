package com.Spring.CouponSystem.Beans;

import com.Spring.CouponSystem.Beans.Enum.ClientType;

public class LoggedResponse {

	public int id;

	public boolean isLogged;

	public ClientType type;

	public LoggedResponse(int id, boolean isLogged, ClientType type) {
		this.id = id;
		this.isLogged = isLogged;
		this.type = type;

	}

	public LoggedResponse() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public ClientType getType() {
		return type;
	}

	public void setType(ClientType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "LoggedResponse [id=" + id + ", isLogged=" + isLogged + ", type=" + type + "]";
	}

}
