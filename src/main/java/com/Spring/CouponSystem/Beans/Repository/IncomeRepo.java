package com.Spring.CouponSystem.Beans.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.CouponSystem.Beans.Income;

@Repository
public interface IncomeRepo extends JpaRepository<Income, Long> {

	List<Income> findByCompanyid(long companyid);
	
	List<Income> findBycustomerid(long customerid);
	

}
