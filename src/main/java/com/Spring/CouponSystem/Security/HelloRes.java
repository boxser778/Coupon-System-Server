package com.Spring.CouponSystem.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRes {

	@Autowired
	private AuthenticationManager authmanager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	@RequestMapping("/hello")
	public String hello() {
		return "HELLO WORLD";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest auth) throws Exception {
		try {
			authmanager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword())

			);
		} catch (BadCredentialsException e) {
			throw new Exception("incorrect username and password");
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	
	}
	
	
//	http://localhost:8080/coupon-system/authenticate
//	{
//		"username":"foo",
//		"password":"foo"
//	}
	
//	http://localhost:8080/coupon-system/hello
//	Authorization : Bearer {token} 

}
