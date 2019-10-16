package com.Spring.CouponSystem.Beans;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
public class Coupon {

	private int id;
	private String title;
	private int amount;
	private Date startDate;
	private Date endDate;
	private CouponType type;
	private String msg;
	private double price;
	private String picture;
//	private Company company;

	public Coupon() {

	}

	public Coupon(int id,String title, int amount, Date startDate, Date endDate, CouponType type, String msg,
			double price, String picture) {

		this.id = id;
		this.title = title;
		this.amount = amount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.msg = msg;
		this.price = price;
		this.picture = picture;
//		this.company = company;
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
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(nullable = false)
	@Basic(optional = false)
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Column(nullable = false)
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Basic(optional = false)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Basic(optional = false)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
//	@Basic(optional = false)
	public CouponType getType() {
		return type;
	}

	public void setType(CouponType type) {
		this.type = type;
	}

	@Column(nullable = false)
	@Basic(optional = false)
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Column(nullable = false)
	@Basic(optional = false)
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(nullable = false)
	@Basic(optional = false)
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

//	@Column(nullable = false)
//	public Company getCompany() {
//		return company;
//	}
//
//	public void setCompany(Company company) {
//		this.company = company;
//	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", amount=" + amount + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", type=" + type + ", msg=" + msg + ", price=" + price + ", picture="
				+ picture + ", company=" + "]";
	}




}
