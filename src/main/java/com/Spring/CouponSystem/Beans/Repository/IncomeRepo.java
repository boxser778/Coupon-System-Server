package com.Spring.CouponSystem.Beans.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.CouponSystem.Beans.Income;

@Repository
public interface IncomeRepo extends JpaRepository<Income, Long> {

//	List<Income> findAllByClientId(int id);

//	@Query("Select i from Income i where i.id = :id")
//	List<Income> findAllIncomeByDescription(int id);
//	@Query("Select i from Income i where i.id = :id AND i.description = :description")
//	List<Income> findAllIncomeByDescription(int id,IncomeType description);

//	Income storeIncome(Income income);

//	List<Income> allIncome();

//	Income viewIncomeByCustomer(int customerId) throws Exception;

//	Income viewIncomeByCompany(int companyId) throws Exception;

//	Income findAllByClientId(int customerId);

}
