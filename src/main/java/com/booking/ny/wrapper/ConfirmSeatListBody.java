package com.booking.ny.wrapper;

import java.util.List;

import com.booking.ny.model.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ConfirmSeatListBody {

  @JsonProperty("seats")
  private List<Long> seats;

  @JsonProperty("customer")
  private CustomerDTO customer;

  @JsonProperty("seatNames")
  private String[] seatNames;

  @JsonProperty("totalAmount")
  private double totalAmount;

  @JsonProperty("moviePosterLink")
  private String moviePosterLink;

  @JsonProperty("movieName")
  private String movieName;


  public CustomerDTO getCustomerDTO() {
    return this.customer;
  }

  public List<Long> getSeats() {
    return this.seats;
  }

  public String[] getSeatNames() {
    return this.seatNames;
  }

  public double getTotalAmount() {
    return this.totalAmount;
  }

  public String getMovieName() {
    return this.movieName;
  }

  public String getMoviePosterlink() {
    return this.moviePosterLink;
  }


  public void setCustomerDTO(CustomerDTO customer) {
    this.customer = customer;
  }


  public void setSeats(List<Long> seats) {
    this.seats = seats;
  }

  public void setSeatNames(String[] seatNames) {
    this.seatNames = seatNames;
  }


  public void setTotalAmount(double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }


  public void setMoviePosterlink(String moviePosterLink) {
    this.moviePosterLink = moviePosterLink;
  }

}