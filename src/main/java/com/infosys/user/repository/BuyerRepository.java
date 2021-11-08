package com.infosys.user.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infosys.user.entity.*;

public interface BuyerRepository extends CrudRepository<Buyer, String> {
	@Query("SELECT b FROM Buyer b WHERE b.email = :emailId")
	Buyer findByEmailId(@Param("emailId") String emailId);
	
	@Query("SELECT b FROM Buyer b WHERE b.phoneNo = :phoneNo")
	List<Buyer> findAllPhone(@Param("phoneNo") String phoneNo);
	
	@Query("UPDATE Buyer b SET b.isPrivileged = 'true' WHERE b.buyerId = :buyerId")
	@Modifying
	Integer updatePrivilegedStatus(@Param("buyerId") String buyerId);
	
}
