package com.Spring.CouponSystem.Beans;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "coupon")
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	@Basic(optional = false)
	private String title;

	@Column(nullable = false)
	@Basic(optional = false)
	private int amount;

	@Column(nullable = false)
	@Basic(optional = false)
	private Date startDate;

	@Column(nullable = false)
	@Basic(optional = false)
	private Date endDate;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CouponType type;

	@Column(nullable = false)
	@Basic(optional = false)
	private String msg;

	@Column(nullable = false)
	@Basic(optional = false)
	private double price;

	@Column(nullable = false)
	@Basic(optional = false)
	private String picture;

	@ManyToOne
	@JoinColumn(name = "company_id")
	@JsonBackReference
	private Company company;

	public Coupon() {

	}

	public Coupon(int id, String title, int amount, Date startDate, Date endDate, CouponType type, String msg,
			double price, String picture, Company company) {

		this.id = id;
		this.title = title;
		this.amount = amount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.msg = msg;
		this.price = price;
		this.picture = picture;
		this.company = company;

	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public CouponType getType() {
		return type;
	}

	public void setType(CouponType type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", amount=" + amount + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", type=" + type + ", msg=" + msg + ", price=" + price + ", picture="
				+ picture + "]";
	}

}
