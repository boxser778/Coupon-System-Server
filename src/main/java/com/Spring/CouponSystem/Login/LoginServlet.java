//package com.Spring.CouponSystem.Login;
//
//import java.io.IOException;
//import java.util.Optional;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
//
///**
// * Servlet implementation class Login
// */
//@CrossOrigin()
//@Controller
//@RequestMapping(value = "login")
//public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	@Autowired
//	LoginService loginService;
//	
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	@RequestMapping(method = RequestMethod.GET)
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.getWriter().append("Login only accepts POST request ");
//		
//	}
//	
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	@CrossOrigin()
//	@RequestMapping(method = RequestMethod.POST)
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		String user = request.getParameter("name");
//		String password = request.getParameter("password");
//		String selector = request.getParameter("selector");
//		ClientType type = ClientType.valueOf(selector.toUpperCase());
//		
//		Optional<?> id = loginService.login(user, password, type);
//		
//		if (!id.isPresent()) {
//			response.sendRedirect(request.getContextPath() + "/login-page.html?err");
//			return;
//		}
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("auth", true);
//		session.setAttribute("id", id.get());
//		
//		switch (type) {
//		case ADMIN:
//			response.sendRedirect(request.getContextPath() + "/admin");
//			break;
//		
//		case COMPANY:
//			response.sendRedirect(request.getContextPath() + "/company");
//			break;
//		
//		case CUSTOMER:
//			response.sendRedirect(request.getContextPath() + "/customer");
//			break;
//		
//		default:
//			response.sendRedirect(request.getContextPath() + "/login");
//		}
//		return;
//	}
//	
//}