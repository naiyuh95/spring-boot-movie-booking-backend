package com.booking.ny.wrapper;

import java.util.List;

import com.booking.ny.model.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfirmSeatListBody {

  @JsonProperty("seats")
  private List<Long> seats;

  @JsonProperty("customer")
  private CustomerDTO customer;

  public CustomerDTO getCustomerDTO() {
    return this.customer;
  }

  public void setCustomerDTO(CustomerDTO customer) {
    this.customer = customer;
  }


  public List<Long> getSeats() {
    return this.seats;
  }


  public void setSeats(List<Long> seats) {
    this.seats = seats;
  }

}