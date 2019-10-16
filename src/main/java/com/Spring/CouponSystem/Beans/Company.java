package com.Spring.CouponSystem.Beans;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Company {

	private int id;
	private String comp_name;
	private String password;
	private String email;

	public Company() {

	}

	public Company(int id,String comp_name, String password, String email) {

		setId(id);
		setComp_Name(comp_name);
		setPassword(password);
		setEmail(email);
	}

	@Id
	@GeneratedValue
	@Basic(optional = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false,unique = true)
	@Basic(optional = false)
	public String getComp_Name() {
		return comp_name;
	}

	public void setComp_Name(String comp_name) {
		this.comp_name = comp_name;
	}

	@Column(nullable = false)
	@Basic(optional = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable = false)
	@Basic(optional = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Coupon> coupons;

	@Override
	public String toString() {
		return "Company [id=" + id + ",comp_name=" + comp_name + ", password=" + password + ", email=" + email
				+ "] \n\"";
	}

}
