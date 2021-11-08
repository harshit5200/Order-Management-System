package com.infosys.user.service;

import java.util.List;

import com.infosys.user.dto.BuyerDTO;
import com.infosys.user.dto.CartDTO;
import com.infosys.user.dto.LoginDTO;
import com.infosys.user.dto.SellerDTO;
import com.infosys.user.dto.WishlistDTO;
import com.infosys.user.exception.UserException;

public interface UserService {
	public String addBuyer(BuyerDTO buyerDTO) throws UserException;
	public List<BuyerDTO> getAllBuyer() throws UserException;
	public String buyerLogin(LoginDTO loginDTO);
	public String addSeller(SellerDTO sellerDTO) throws UserException;
	public List<SellerDTO> getAllSeller() throws UserException;
	public String sellerLogin(LoginDTO loginDTO);
	public void deleteBuyer(String buyerId) throws UserException;
	public void deleteSeller(String sellerId) throws UserException;
	public String addCart(CartDTO cartDTO) throws UserException;
	public void deleteCart(String buyerId, String productId) throws UserException;
	public Boolean validateBuyer(String buyerId) throws UserException;
	public Boolean validateSeller(String sellerId) throws UserException;
	public String addWishlist(WishlistDTO wishlistDTO) throws UserException;
	public void deleteWishlist(String buyerId, String productId) throws UserException;
	public void moveWishlist(CartDTO cartDTO) throws UserException;
	public Boolean validatePrivilegedBuyer(String buyerId) throws UserException;
	public List<CartDTO> getCart(String buyerId) throws UserException;
}
