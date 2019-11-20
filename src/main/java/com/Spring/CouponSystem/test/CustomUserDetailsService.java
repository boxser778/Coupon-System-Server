//package com.Spring.CouponSystem.test;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.google.common.base.Optional;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<Users> optionalUsers = usersRepository.findByName(username);
//
////        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//        return (UserDetails) optionalUsers.stream().map(CustomUserDetails::new);
////                .map(CustomUserDetails::new).get();
//    }
//}