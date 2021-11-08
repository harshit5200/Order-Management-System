package com.infosys.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.infosys.user.dto.*;
import com.infosys.user.service.*;
import com.infosys.user.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/api")
@Validated
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private Environment environment;
	
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value = "/validate/buyer/{buyerId}")
	public ResponseEntity<Boolean> validateBuyer(@PathVariable String buyerId) throws UserException{
		Boolean result = userService.validateBuyer(buyerId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	@GetMapping(value = "/validate/seller/{sellerId}")
	public ResponseEntity<Boolean> validateSeller(@PathVariable String sellerId) throws UserException{
		Boolean result = userService.validateSeller(sellerId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	@GetMapping(value = "/validate/privileged/{buyerId}")
	public ResponseEntity<Boolean> validatePrivilegedBuyer(@PathVariable String buyerId) throws UserException{
		Boolean result = userService.validateSeller(buyerId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/buyer")
	public ResponseEntity<List<BuyerDTO>> getAllBuyers() throws UserException {
		List<BuyerDTO> buyerList = userService.getAllBuyer();
		return new ResponseEntity<>(buyerList, HttpStatus.OK);
	}
	@PostMapping(value = "/buyer/registration")
	public ResponseEntity<String> addBuyer(@Valid @RequestBody BuyerDTO buyer) throws UserException {
		String buyerId = userService.addBuyer(buyer);
		String successMessage;
		if(buyerId == "Buyer Already Exist") {
			successMessage = "" + buyerId;
		}
		else if(buyerId == "Phone Number Is Already In Use!") {
			successMessage = "" + buyerId;
		}
		else {
			successMessage = environment.getProperty("API.INSERT_SUCCESS") + buyerId;
		}
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	@PostMapping(value = "/buyer/login")
	public String buyerLogin(@RequestBody LoginDTO loginDTO) {
		LOGGER.info("Login request for customer {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
		return userService.buyerLogin(loginDTO);
	}
	@GetMapping(value = "/seller")
	public ResponseEntity<List<SellerDTO>> getAllSellers() throws UserException {
		List<SellerDTO> sellerList = userService.getAllSeller();
		return new ResponseEntity<>(sellerList, HttpStatus.OK);
	}
	@PostMapping(value = "/seller/registration")
	public ResponseEntity<String> addSeller(@Valid @RequestBody SellerDTO buyer) throws UserException {
		String sellerId = userService.addSeller(buyer);
		String successMessage;
		if(sellerId == "Seller Already Exist!") {
			successMessage = "" + sellerId;
		}
		if(sellerId == "Seller Already Exist!") {
			successMessage = "" + sellerId;
		}
		else if(sellerId == "Phone Number Is Already In Use!") {
			successMessage = "" + sellerId;
		}
		else {
			successMessage = environment.getProperty("API.INSERT_SUCCESS1");
		}
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	@PostMapping(value = "/seller/login")
	public String sellerLogin(@RequestBody LoginDTO loginDTO) {
		LOGGER.info("Login request for customer {} with password {}", loginDTO.getEmail(),loginDTO.getPassword());
		return userService.sellerLogin(loginDTO);
	}
	@DeleteMapping(value = "/buyer/{buyerId}")
	public ResponseEntity<String> deleteBuyer(@PathVariable String buyerId) throws UserException {
		userService.deleteBuyer(buyerId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@DeleteMapping(value = "/seller/{sellerId}")
	public ResponseEntity<String> deleteSeller(@PathVariable String sellerId) throws UserException {
		userService.deleteSeller(sellerId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS1");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@PostMapping(value = "/buyer/cart")
	public ResponseEntity<String> addCart(@RequestBody CartDTO cart) throws UserException {
		String cartId = userService.addCart(cart);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS2");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	@GetMapping(value = "/buyer/cart")
	public ResponseEntity<List<CartDTO>> getCart(@RequestBody String buyerId) throws UserException {
		List<CartDTO> cart = userService.getCart(buyerId);
		return new ResponseEntity<>(cart, HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/buyer/{buyerId}/{productId}/cart")
	public ResponseEntity<String> deleteCart(@PathVariable String buyerId, @PathVariable String productId) throws UserException {
		userService.deleteCart(buyerId, productId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS2");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@PostMapping(value = "/buyer/wishlist")
	public ResponseEntity<String> addWishlist(@RequestBody WishlistDTO wishlist) throws UserException {
		String wishlistId = userService.addWishlist(wishlist);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS3");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/buyer/{buyerId}/{productId}/wishlist")
	public ResponseEntity<String> deleteWishlist(@PathVariable String buyerId, @PathVariable String productId) throws UserException {
		userService.deleteWishlist(buyerId, productId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS3");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@PostMapping(value = "/buyer/move")
	public ResponseEntity<String> moveWishlist(@RequestBody CartDTO cart) throws UserException {
		userService.moveWishlist(cart);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS4");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
}
