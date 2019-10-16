package com.Spring.CouponSystem.Beans.Controllers;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.LoginException;
import javax.websocket.server.PathParam;

import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.CouponSystem.Session;
import com.Spring.CouponSystem.Beans.Company;
import com.Spring.CouponSystem.Beans.Coupon;
import com.Spring.CouponSystem.Beans.Enum.CouponType;
import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
import com.Spring.CouponSystem.Beans.Repository.CouponRepo;
import com.Spring.CouponSystem.Beans.Services.CompanyService;
import com.Spring.CouponSystem.Login.ClientType;
import com.Spring.CouponSystem.Login.CouponClient;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("company")
public class CompanyCTR {

	@Autowired
	private CouponRepo couponRepo;
	@Autowired
	private CompanyRepo companyRepo;

	@Autowired
	CompanyService companySerive = new CompanyService();
	
	@Autowired
	private Map<String, Session> tokens;
	
//	private Session exists(String token) {
//		return LoginController.tokens.get(token);
//	}
	
	
	// http://localhost:8080/company/coupon
	@GetMapping("/coupon")
	public ResponseEntity<List<Coupon>> getAllCoupons() {
		return new ResponseEntity<List<Coupon>>(couponRepo.findAll(), HttpStatus.OK);
	}

	// http://localhost:8080/company/coupon/{id}
	@GetMapping("/coupon/id/{id}")
	public ResponseEntity<Coupon> getCoupon(@PathVariable("id") int id) {
		return new ResponseEntity<Coupon>(couponRepo.findById(id), HttpStatus.OK);
	}

	// http://localhost:8080/company/coupon
	// {"id":4,"amount":1,"endDate" : "2006-02-01","msg" :
	// "asdasd","picture":"asdasdasd", "price" : 123, "startDate" :
	// "2006-02-01","title":"shmuel","type" : "FOOD"}
//	@PostMapping("/coupon")
//	public ResponseEntity<?> newCoupon(@RequestBody Coupon c,@RequestBody Company company) {
//		if (companySerive.findCoupon(c.getTitle()) != null) {
//			return new ResponseEntity<String>("Id allready exist", HttpStatus.BAD_REQUEST);
//		}
//		return null;
//	}	

//		http://localhost:8080/company/coupon/{id}
//	@DeleteMapping("/coupon/{id}")
//	public ResponseEntity<?> removeCoupon(@PathVariable("id") long id,Company company) {
//		companySerive.deleteCoupon(company,id);
//		return new ResponseEntity<String>("Coupon " + id + " was deleted!", HttpStatus.OK);
//	}

//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//	@GetMapping("/coupon/title/{title}")
//	public ResponseEntity<List<Coupon>> getCouponByTitle(@PathVariable("title") String title) {
//		return new ResponseEntity<List<Coupon>>(couponRepo.findByTitle(title),HttpStatus.OK);
//	}

	@GetMapping("/coupon/type/{type}")
	public ResponseEntity<List<Coupon>> getCouponByType(@PathVariable("type") String type) {
		return new ResponseEntity<List<Coupon>>(couponRepo.findByType(type),HttpStatus.OK);
	}
	
	@GetMapping("/coupon/endDate/{endDate}")
	public ResponseEntity<List<Coupon>> getCouponByEndDate(@PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
		return new ResponseEntity<List<Coupon>>(companySerive.getCouponsByEndDate(endDate),HttpStatus.OK);
	}

//	public CompanyCTR login(String name, String password, ClientType clientType) throws LoginException, Exception {
//		
//		if (name.equals("company") && password.equals("company") && clientType.equals(ClientType.COMPANY)) {
//		
//	}
//		return new CompanyCTR();
//
//	}
	
	
	
	
	
	
	
//	
//	@Autowired
//	private CompanyService companyService;
//
//	@Autowired
//	private CouponRepository couponRepository;
//	
//	@Autowired
//	private IncomeService incomeService;
//
//	@Autowired
//	private Map<String, Session> tokens;
//
//	private Session exists(String token) {
//		return LoginController.tokens.get(token);
//	}
//
//	@PostMapping("/createCoupon/{token}")
//	public ResponseEntity<String> createCoupon(@RequestBody Coupon coupon, @PathVariable String token)
//			throws Exception {
//		Session session = exists(token);
//		if (session == null) {
//			throw new Exception("Something went wrong with the session !!");
//		} else if (session != null) {
//			session.setLastAccesed(System.currentTimeMillis());
//			try {
//				((CompanyServiceImpl) session.getFacade()).createCoupon(coupon);
//				return new ResponseEntity<>("coupon created  " + coupon, HttpStatus.OK);
//			} catch (Exception e) {
//				return new ResponseEntity<>(e.getMessage() + e.getStackTrace(), HttpStatus.UNAUTHORIZED);
//			}
//		}
//		return null;
//	}
//
//	@PostMapping("/updateCoupon/{token}")
//	public ResponseEntity<Coupon> updateCoupon(@PathVariable String token, @RequestParam long id,
//			@RequestParam Date endDate, @RequestParam double price) throws Exception {
//		Session session = exists(token);
//		if (session == null) {
//			throw new Exception("Something went wrong with the session !!");
//		} else if (session != null) {
//			session.setLastAccesed(System.currentTimeMillis());
//			try {
//				Coupon coupon = null;
//				coupon = couponRepository.findById(id).get();
//				if (coupon != null) {
//					((CompanyServiceImpl) session.getFacade()).updateCoupon(coupon, endDate, price);
//					ResponseEntity<Coupon> result = new ResponseEntity<>(coupon, HttpStatus.OK);
//					return result;
//				}
//			} catch (Exception e) {
//				System.out.println("Cannot update coupon");
//			}
//		}
//		return null;
//	}
//
//	@DeleteMapping("/deleteCoupon/{coupon_id}/{token}")
//	public void deleteCoupon(@PathVariable long coupon_id, @PathVariable String token) throws Exception {
//		Session session = exists(token);
//		if (session == null) {
//			throw new Exception("Something went wrong with the session !!");
//		} else if (session != null) {
//			session.setLastAccesed(System.currentTimeMillis());
//			try {
//				Coupon coupon = null;
//				coupon = couponRepository.findById(coupon_id).get();
//				if (coupon != null) {
//					((CompanyServiceImpl) session.getFacade()).deleteCoupon(coupon_id);
//				}
//			} catch (Exception e) {
//				System.out.println("Failed to delete coupon " + coupon_id + e.getMessage());
//			}
//		}
//	}
//
//	@GetMapping("/companyById/{id}/{token}")
//	public Company companyById(@PathVariable long id, @PathVariable String token) throws Exception {
//		Session session = exists(token);
//		if (session == null) {
//			throw new Exception("Something went wrong with the session !!");
//		} else if (session != null) {
//			session.setLastAccesed(System.currentTimeMillis());
//			try {
//				return ((CompanyServiceImpl) session.getFacade()).companyById(id);
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		return null;
//	}
//
//	@GetMapping("/getAllCompanyCoupons/{company_id}/{token}")
//	public List<Coupon> getAllCompanyCoupons(@PathVariable long company_id, @PathVariable String token)
//			throws Exception {
//		Session session = exists(token);
//		if (session == null) {
//			throw new Exception("Something went wrong with the session !!");
//		} else if (session != null) {
//			session.setLastAccesed(System.currentTimeMillis());
//			try {
//				return ((CompanyServiceImpl) session.getFacade()).getAllCompanyCoupons(company_id);
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		return null;
//	}
//
//	@GetMapping("/getCouponsByCouponType/{couponType}/{token}")
//	public List<Coupon> getCouponsByCouponType(@PathVariable CouponType couponType, @PathVariable String token)
//			throws Exception {
//		Session session = exists(token);
//		if (session == null) {
//			throw new Exception("Something went wrong with the session !!");
//		} else if (session != null) {
//			session.setLastAccesed(System.currentTimeMillis());
//			try {
//				return ((CompanyServiceImpl) session.getFacade()).getCouponsByCouponType(couponType);
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		return null;
//	}
//	
//	
//	@GetMapping("/getCouponsByPrice/{price}/{token}")
//	public List<Coupon> getCouponsByPrice(@PathVariable double price, @PathVariable String token)
//			throws Exception {
//		Session session = exists(token);
//		if (session == null) {
//			throw new Exception("Something went wrong with the session !!");
//		} else if (session != null) {
//			session.setLastAccesed(System.currentTimeMillis());
//			try {
//				return ((CompanyServiceImpl) session.getFacade()).getCouponsByPrice(price);
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		return null;
//	}
//	
////	@GetMapping(value="/getCouponsByEndDate/{endDate}/{token}")
//////	@RequestMapping(value = "/getCompanyByEndDate/{endDate}/{token}", method =RequestMethod.GET, consumes="application/json")
////	public List<Coupon> getCouponsByEndDate(@PathVariable long endDate, @PathVariable String token)
////			throws Exception {
//////		Date d = new Date(3918-1900, 10, 10);
//////		System.out.println(d.getTime());
//////		System.out.println(System.currentTimeMillis());
////		Session session = exists(token);
////		if (session == null) {
////			throw new Exception("Something went wrong with the session !!");
////		} else if (session != null) {
////			session.setLastAccesed(System.currentTimeMillis());
////			try {
////				Date date = new Date(endDate);
////				return ((CompanyServiceImpl) session.getFacade()).getCouponsByEndDate(date);
////			} catch (Exception e) {
////				System.out.println(e.getMessage());
////			}
////		}
////		return null;
////	}
//	
//	
//	
//	
//	
//	@GetMapping("/viewIncomeByCompanyId/{companyId}/{token}")
//	public List<Income> viewIncomeByCompanyId(@PathVariable long companyId, @PathVariable String token)
//			throws Exception {
//		Session session = exists(token);
//		if (session == null) {
//			throw new Exception("Something went wrong with the session !!");
//		} else if (session != null) {
//			session.setLastAccesed(System.currentTimeMillis());
//			try {
//				return incomeService.viewIncomeByCompany(companyId);
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		return null;
//	}
//
//	
//}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
