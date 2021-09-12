package com.booking.ny.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 


public class CustomerDTO {


	@NotBlank(message = "Customer name cannot be blank")
	private String customerName;
	@NotBlank(message = "Customer phone number cannot be blank")
	private int contactNumber;
	@NotBlank(message = "Customer email cannot be blank")
	private String email;
	


  public String getCustomerName() {
    return this.customerName;
  }

  public int getContactNumber() {
    return this.contactNumber;
  }

  public String getEmail() {
    return this.email;
  }



  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public void setContactNumber(int contactNumber) {
    this.contactNumber = contactNumber;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}