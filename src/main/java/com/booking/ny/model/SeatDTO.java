package com.booking.ny.model;
import java.util.Objects;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeatDTO {


  @Min(value= 0, message = "Seat id must be greater or equal to 0")
	private int seatId;
	@NotBlank(message = "Seat Type cannot be blank")
	private String seatType;
	@Min(value= 0,message = "Seat columns must be greater or equal to 0")
	private int seatColumns;
	@Min(value= 0,message = "Seat rows must be greater or equal to 0")
	private int seatRows;



  public int getSeatId() {
    return this.seatId;
  }

  public String getSeatType() {
    return this.seatType;
  }

  public int getSeatColumns() {
    return this.seatColumns;
  }

  public int getSeatRows() {
    return this.seatRows;
  }




  public void setSeatId(int seatId) {
    this.seatId = seatId;
  }

  public void setSeatType(String seatType) {
    this.seatType = seatType;
  }

  public void setSeatColumns(int seatColumns) {
    this.seatColumns = seatColumns;
  }

  public void setSeatRows(int seatRows) {
    this.seatRows = seatRows;
  }




}