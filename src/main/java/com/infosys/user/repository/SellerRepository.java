package com.infosys.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infosys.user.entity.Seller;

public interface SellerRepository extends CrudRepository<Seller, String> {
	@Query("SELECT s FROM Seller s WHERE s.email = :emailId")
	Seller findByEmailId(@Param("emailId") String emailId);
	@Query("SELECT s FROM Seller s WHERE s.phoneNo = :phoneNo")
	List<Seller> findAllPhoneNo(@Param("phoneNo") String phoneNo);
}
