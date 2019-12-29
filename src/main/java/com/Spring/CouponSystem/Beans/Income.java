package com.Spring.CouponSystem.Beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.Spring.CouponSystem.Beans.Enum.IncomeType;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "income")
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "incomeId")
	private int id;

	@Basic(optional = false)
	@Column(nullable = false)
	private long companyid;

	@Basic(optional = false)
	@Column(nullable = false)
	private long customerid;

	@Column(nullable = false)
	@Basic(optional = false)
	private String name;

	@Column(nullable = false)
	@Basic(optional = false)
//	@JsonFormat(pattern = "dd-MM-yyyy")
	@JsonFormat(pattern = "dd-MM-yyyy", timezone = JsonFormat.DEFAULT_LOCALE)
	private String date;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private IncomeType description;

	@Column(nullable = false)
	@Basic(optional = false)
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public IncomeType getDescription() {
		return description;
	}

	public void setDescription(IncomeType description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getCompanyid() {
		return companyid;
	}

	public long getCustomerid() {
		return customerid;
	}

	public void setCompanyid(long companyid) {
		this.companyid = companyid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	@Override
	public String toString() {
		return "Income [id=" + id + ", companyid=" + companyid + ", customerid=" + customerid + ", name=" + name
				+ ", date=" + date + ", description=" + description + ", price=" + price + "]";
	}

}
