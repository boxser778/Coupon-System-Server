//package com.Spring.CouponSystem.Web;
//
//import java.io.Serializable;
//import javax.xml.bind.annotation.XmlRootElement;
//
//import com.Spring.CouponSystem.Beans.Customer;
//
//@XmlRootElement
//public class WebCustomer implements Serializable {
//	private static final long serialVersionUID = 1L;
//	
//	private int id;
//	private String custName;
//	private String password;
//	
//	public WebCustomer() {
//		super();
//	}
//	
//	public WebCustomer(int id, String custName, String password) {
//		super();
//		this.id = id;
//		this.custName = custName;
//		this.password = password;
//	}
//	
//	public WebCustomer(Customer cust) {
//		super();
//		this.id = cust.getId();
//		this.custName = cust.getCustomerName();
//		this.password = cust.getCustomerPassword();
//	}
//	
//	public int getId() {
//		return id;
//	}
//	
//	public void setId(int id) {
//		this.id = id;
//	}
//	
//	public String getCustName() {
//		return custName;
//	}
//	
//	public void setCustName(String custName) {
//		this.custName = custName;
//	}
//	
//	public String getPassword() {
//		return password;
//	}
//	
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	
//	public static WebCustomer returnWebCustomer(Customer Customer) {
//		return new WebCustomer(Customer.getId(), Customer.getCustomerName(), Customer.getCustomerPassword());
//	}
//	
//	public static Customer returnCustomer(WebCustomer webCustomer) {
//		Customer customer = new Customer(webCustomer.getCustName(), webCustomer.getPassword());
//		customer.setId(webCustomer.getId());
//		return customer;
//	}
//	
//}