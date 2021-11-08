package com.infosys.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infosys.user.entity.BuyerProductId;
import com.infosys.user.entity.Wishlist;

public interface WishlistRepository extends CrudRepository<Wishlist, BuyerProductId>{
	@Query("SELECT w FROM Wishlist w WHERE w.buyerId = :buyerId AND w.productId = :productId")
	Optional<Wishlist> findByWishlist(@Param("buyerId") String buyerId, @Param("productId") String productId);
	
	@Query("DELETE FROM Wishlist w WHERE w.buyerId = :buyerId AND w.productId = :productId")
	@Modifying
	void deleteByWishlist(@Param("buyerId") String buyerId, @Param("productId") String productId);
}
