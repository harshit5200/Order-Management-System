package com.infosys.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SellerDTO {
	String sellerId;
	@NotNull(message = "{seller.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{seller.name.invalid}")
	String name;
	@Email(message = "{seller.emailid.invalid}")
	@NotNull(message = "{seller.emailid.absent}")
	String email;
	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message = "{seller.phoneno.invalid}")
	@NotNull(message = "{seller.phoneno.absent}")
	String phoneNo;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "{seller.password.invalid}")
	@NotNull(message = "{seller.password.absent}")
	String password;
	Boolean isActive;
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
