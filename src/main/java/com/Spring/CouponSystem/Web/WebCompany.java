//package com.Spring.CouponSystem.Web;
//
//import java.io.Serializable;
//import javax.xml.bind.annotation.XmlRootElement;
//
//import com.Spring.CouponSystem.Beans.Company;
//
//
//@XmlRootElement
//public class WebCompany implements Serializable {
//	private static final long serialVersionUID = 1L;
//	
//	private int id;
//	private String compName;
//	private String password;
//	private String email;
//	
//	public WebCompany() {
//		super();
//	}
//	
//	public WebCompany(int id, String compName, String password, String email) {
//		super();
//		this.id = id;
//		this.compName = compName;
//		this.password = password;
//		this.email = email;
//	}
//	
//	public WebCompany(Company comp) {
//		super();
//		this.id = comp.getId();
//		this.compName = comp.getComp_Name();
//		this.password = comp.getPassword();
//		this.email = comp.getEmail();
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
//	public String getCompName() {
//		return compName;
//	}
//	
//	public void setCompName(String compName) {
//		this.compName = compName;
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
//	public String getEmail() {
//		return email;
//	}
//	
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
//	public static Company retutnCompany(WebCompany webCompany) {
//		Company company = new Company(webCompany.getCompName(), webCompany.getPassword(),
//				webCompany.getEmail());
//		company.setId(webCompany.getId());
//		return company;
//		
//	}
//	
//	public static WebCompany retutnWebCompany(Company company) {
//		return new WebCompany(company.getId(), company.getComp_Name(), company.getPassword(),
//				company.getEmail());
//		
//	}
//	
//}