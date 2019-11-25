//package com.Spring.CouponSystem.Beans.Controllers;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Spring.CouponSystem.CouponSystem;
//import com.Spring.CouponSystem.Session;
//import com.Spring.CouponSystem.Beans.ClientTypeConverter;
//import com.Spring.CouponSystem.Beans.Company;
//import com.Spring.CouponSystem.Beans.Customer;
//import com.Spring.CouponSystem.Beans.LoginUser;
//import com.Spring.CouponSystem.Beans.Token;
//import com.Spring.CouponSystem.Beans.Tokens;
//import com.Spring.CouponSystem.Beans.Repository.CompanyRepo;
//import com.Spring.CouponSystem.Beans.Repository.CustomerRepo;
//import com.Spring.CouponSystem.Beans.Services.AdminService;
//import com.Spring.CouponSystem.Beans.Services.CompanyService;
//import com.Spring.CouponSystem.Beans.Services.CustomerService;
//import com.Spring.CouponSystem.Login.ClientType;
//import com.Spring.CouponSystem.Login.CouponClient;
//
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
//@RestController
//@RequestMapping("Login")
//public class LoginController {
//
//	public static Map<String, Session> tokens = new HashMap<String, Session>();
//
//	@Resource
//	private CouponSystem couponSystem;
//
//	@PostMapping("login")
//	public ResponseEntity<Token> login(@RequestBody LoginUser loginUser) {
////		if (!clientType.equals("ADMIN") && !clientType.equals("COMPANY") && !clientType.equals("CUSTOMER")) {
////			return new ResponseEntity<>("Check clientType again", HttpStatus.UNAUTHORIZED);
////		}
//
//		Session session = new Session();
//		CouponClient facade;
//		String token = UUID.randomUUID().toString();
//		long lastAccessed = System.currentTimeMillis();
//
//		try {
//			facade = couponSystem.login(loginUser.getUsername(), loginUser.getPassword(), ClientTypeConverter.convertStringToType(loginUser.getClientType()));
//			ClientTypeConverter.convertStringToType(loginUser.getClientType());
//			session.setCouponClient(facade);
//			session.setLastAccessed(lastAccessed);
//			tokens.put(token, session);
//			Token tokenObject = new Token(token, loginUser.getClientType());
//			return new ResponseEntity<>(tokenObject, HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//}
