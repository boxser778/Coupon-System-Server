package com.Spring.CouponSystem.Beans.Controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.CouponSystem.CouponSystem;
import com.Spring.CouponSystem.Beans.LoggedResponse;
import com.Spring.CouponSystem.Beans.LoginUser;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Login")
public class LoginController {

	@Resource
	private CouponSystem couponSystem;

	@PostMapping
	public LoggedResponse login(@RequestBody LoginUser loginUser, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession(false);
		LoggedResponse lr = new LoggedResponse();
		if (session != null) {
			session.invalidate();
		}
		session = req.getSession();
		LoginUser newUser = couponSystem.login(loginUser);

		session.setAttribute("user", newUser);

		if (!newUser.equals(null)) {
			lr.setId(newUser.getUserId());
			lr.setLogged(true);
			lr.setType(newUser.getClientType());
			return lr;
		} else {

			lr.setLogged(false);
			return lr;
		}

	}

}
