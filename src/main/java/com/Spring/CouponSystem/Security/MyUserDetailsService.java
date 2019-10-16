//package com.Spring.CouponSystem.Security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private UserRepo userRepo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
//		
//		User user1 = userRepo.findByUserName(user);
//		if (user == null ) {
//			throw new UsernameNotFoundException("User not exist");
//		}
//		return new UserDeitailsImpl(user1);
//	}
//
//}
