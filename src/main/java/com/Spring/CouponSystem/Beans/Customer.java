package com.Spring.CouponSystem.Beans;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	private int id;
	private String customerName;
	private String customerPassword;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Coupon> coupons;

	public Customer(int id, String customerName, String customerPassword) {

		this.id = id;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
	}

	public Customer() {

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

	@Column(nullable = false, unique = true)
	@Basic(optional = false)
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(nullable = false)
	@Basic(optional = false)
	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

//	@JoinTable(name = "Customer-Coupon" ){(@JoinColumn (name = "customer_id"))};
//	@JoinColumns(foreignKey = "customer_Id",value = "id");

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", customerPassword=" + customerPassword
				+ "] \n\"";
	}

//	public List<Coupon> getCoupons() {
//		
//		return coupons;
//	}

}
