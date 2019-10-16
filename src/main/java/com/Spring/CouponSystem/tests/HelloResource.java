//package com.Spring.CouponSystem.tests;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Spring.CouponSystem.Beans.Company;
//
//@RequestMapping("/rest/hello")
//@RestController
//public class HelloResource {
//
//	@Autowired
//	UsersRepository usersRepository;
//	
//	@PostMapping("/insertRole")
//	public String createRole(@RequestBody Role r) {
//		UsersRepository.save(r);
//		return "created";
//	}
//
//    @GetMapping("/all")
//    public String hello() {
//        return "Hello Youtube";
//    }
//
//    @PreAuthorize("hasAnyRole('ADMIN')")
//    @GetMapping("/secured/all")
//    public String securedHello() {
//        return "Secured Hello";
//    }
//
//    @GetMapping("/secured/alternate")
//    public String alternate() {
//        return "alternate";
//    }
//}