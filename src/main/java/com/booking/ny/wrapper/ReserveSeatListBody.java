package com.booking.ny.wrapper;
import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.List;

public class ReserveSeatListBody {
  

  private List<Long> seats;




  public List<Long> getSeats() {
    return this.seats;
  }


  public void setSeats(List<Long> seats) {
    this.seats = seats;
  }

}