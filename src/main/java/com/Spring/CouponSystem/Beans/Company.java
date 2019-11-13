package com.Spring.CouponSystem.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Basic(optional = false)
	@Column(nullable = false)
	private String comp_Name;

	@Basic(optional = false)
	@Column(nullable = false)
	private String password;

	@Basic(optional = false)
	@Column(nullable = false)
	private String email;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company", orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonManagedReference("company")
	@JsonIgnore
	private List<Coupon> coupons = new ArrayList<>(0);

	public Company() {

	}

	public Company(int id, String comp_name, String password, String email) {

		setId(id);
		setComp_Name(comp_name);
		setPassword(password);
		setEmail(email);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComp_Name() {
		return comp_Name;
	}

	public void setComp_Name(String comp_name) {
		this.comp_Name = comp_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ",comp_name=" + comp_Name + ", password=" + password + ", email=" + email
				+ "] \n\"";
	}

}
