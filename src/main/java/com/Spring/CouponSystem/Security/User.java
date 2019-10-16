//package com.Spring.CouponSystem.Security;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//
//@Entity
//public class User {
//
//	private long id;
//	private String username;
//	private String password;
//	
//	public User() {
//		
//	}
//
//	public User(long id, String username, String password) {
//		
//		this.id = id;
//		this.username = username;
//		this.password = password;
//	}
//	
//	@Id
//	@GeneratedValue
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	@Column(nullable = false)
//	public String getUser() {
//		return username;
//	}
//
//	public void setUser(String username) {
//		this.username = username;
//	}
//
//	@Column(nullable = false)
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", user=" + username + ", password=" + password + "]";
//	}
//	
//	
//
//}
