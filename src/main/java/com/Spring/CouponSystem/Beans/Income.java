package com.Spring.CouponSystem.Beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.Spring.CouponSystem.Beans.Enum.IncomeType;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Income {

	
	private int id;
	private String name;
	private Date date;
	private IncomeType description;
	private double amount;
	
	@Id
	@GeneratedValue
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	@Column(nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	public IncomeType getDescription() {
		return description;
	}
	
	public void setDescription(IncomeType description) {
		this.description = description;
	}
	
	@Column(nullable = false)
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "Income [id=" + id + ", name=" + name + ", date=" + date + ", description=" + description
				+ ", amount=" + amount + "]";
	}
}
	
	