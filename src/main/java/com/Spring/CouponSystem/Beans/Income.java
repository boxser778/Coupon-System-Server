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
import javax.persistence.Table;

import com.Spring.CouponSystem.Beans.Enum.IncomeType;

@Entity
@Table(name = "income")
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "incomeId")
	private int id;

	@Column(nullable = false)
	@Basic(optional = false)
	private String name;

	@Column(nullable = false)
	@Basic(optional = false)
//	@JsonFormat(pattern="dd-MM-yyyy")
//	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Income [id=" + id + ", name=" + name + ", date=" + date + ", description=" + description + ", price="
				+ price + "]";
	}

}
