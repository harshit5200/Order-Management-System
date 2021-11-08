package com.infosys.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infosys.user.entity.BuyerProductId;
import com.infosys.user.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, BuyerProductId> {
	@Query("SELECT c FROM Cart c WHERE c.buyerId = :buyerId AND c.productId = :productId")
	Optional<Cart> findByCart(@Param("buyerId") String buyerId, @Param("productId") String productId);
	
	@Query("SELECT c FROM Cart c WHERE c.buyerId = :buyerId")
	Iterable<Cart> findCart(@Param("buyerId") String buyerId);
	
	@Query("DELETE FROM Cart c WHERE c.buyerId = :buyerId AND c.productId = :productId")
	@Modifying
	void deleteByCart(@Param("buyerId") String buyerId, @Param("productId") String productId);
}
