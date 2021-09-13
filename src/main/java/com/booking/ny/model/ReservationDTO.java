package com.booking.ny.model;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservationDTO {

  @Min(value= 0, message = "Reservation id must be greater or equal to 0")
	private long reservationId;

  @NotNull(message = "Reservation Confirmed TimeStamp cannot be null")
  private Timestamp reservationConfirmedTimeStamp;

  @NotNull(message = "Reservation Start TimeStamp cannot be null")
  private Timestamp reservationStartTimeStamp;

  @NotNull(message = "Reservation End TimeStamp cannot be null")
  private Timestamp reservationEndTimeStamp;
  
  @NotBlank(message = "Reservation Status cannot be blank")
  private String reservationStatus;


  public Timestamp getReservationConfirmedTimeStamp() {
    return this.reservationConfirmedTimeStamp;
  }


  public Timestamp getReservationStartTimeStamp() {
    return this.reservationStartTimeStamp;
  }

  public Timestamp getReservationEndTimeStamp() {
    return this.reservationEndTimeStamp;
  }

  public String getReservationStatus() {
    return this.reservationStatus;
  }



  public long getReservationId() {
    return this.reservationId;
  }

  public void setReservationId(long reservationId) {
    this.reservationId = reservationId;
  }

  public void setReservationConfirmedTimeStamp(Timestamp reservationConfirmedTimeStamp) {
    this.reservationConfirmedTimeStamp = reservationConfirmedTimeStamp;
  }

  public void setReservationStartTimeStamp(Timestamp reservationStartTimeStamp) {
    this.reservationStartTimeStamp = reservationStartTimeStamp;
  }

  public void setReservationEndTimeStamp(Timestamp reservationEndTimeStamp) {
    this.reservationEndTimeStamp = reservationEndTimeStamp;
  }

  public void setReservationStatus(String reservationStatus) {
    this.reservationStatus = reservationStatus;
  }




}