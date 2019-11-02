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

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
//	@JsonFormat(pattern="dd-MM-yyyy")
//	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private IncomeType description;

	@Column(nullable = false)
	private double amount;

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public IncomeType getDescription() {
		return description;
	}

	public void setDescription(IncomeType description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Income [id=" + id + ", name=" + name + ", date=" + date + ", description=" + description + ", amount="
				+ amount + "]";
	}
}
