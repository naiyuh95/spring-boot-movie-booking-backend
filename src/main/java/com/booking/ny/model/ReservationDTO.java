package com.booking.ny.model;
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

	@NotNull(message = "Reservation Date cannot be null")
	private Date reservationDate;

  public long getReservationId() {
    return this.reservationId;
  }

  public void setReservationId(long reservationId) {
    this.reservationId = reservationId;
  }

  public Date getReservationDate() {
    return this.reservationDate;
  }

  public void setReservationDate(Date reservationDate) {
    this.reservationDate = reservationDate;
  }


}