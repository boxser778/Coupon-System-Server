//package com.Spring.CouponSystem.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.NoOp;
//
//@Service
//public class SecurityConfig extends WebSecurityConfigurerAdapter 
//{
//	
//	@Autowired
//	private  UserDetailsService userDetailsService;
//	
//	@Bean
//	private AuthenticationProvider autoProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//		return provider;
//	}
//}
