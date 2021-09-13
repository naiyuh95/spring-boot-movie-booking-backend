package com.booking.ny.model;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeatDTO {


  @Min(value= 1, message = "Seat id must be greater or equal to 1")
	private int seatId;
	@NotBlank(message = "Seat Type cannot be blank")
	private String seatType;
	@Min(value= 1,message = "Seat Number must be greater or equal to 1")
  private int seatNumber;
	@NotBlank(message = "Seat Name cannot be blank")
	private String seatName;
  @Min(value= 0, message = "Seat price must be greater or equal to 0")
  private double price;


  public SeatDTO(){}

  public SeatDTO(String seatType, int seatNumber,double price, String seatName) {

    this.seatType = seatType;
    this.seatNumber = seatNumber;
    this.price = price;
    this.seatName = seatName;
  }


  public int getSeatId() {
    return this.seatId;
  }

  public String getSeatType() {
    return this.seatType;
  }

  public int getSeatNumber() {
    return this.seatNumber;
  }
  

  public double getPrice() {
    return this.price;
  }

  public String getSeatName() {
    return this.seatName;
  }


  public void setSeatId(int seatId) {
    this.seatId = seatId;
  }

  public void setSeatType(String seatType) {
    this.seatType = seatType;
  }

  public void setSeatName(String seatName) {
    this.seatName = seatName;
  }

  public void setSeatNumber(int seatNumber) {
    this.seatNumber = seatNumber;
  }



  public void setPrice(double price) {
    this.price = price;
  }






}