// package com.booking.ny.model;

// import java.util.Objects;

// import java.util.Date;
// import java.util.List;

// import javax.validation.constraints.Min;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotNull;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties(ignoreUnknown = true)
// public class SeatReservedDTO {


  
//   @Min(value= 0, message = "Seat Reservation id must be greater or equal to 0")
// 	private long seatReservedId;
// 	@NotBlank(message = "Seat Reservation Status cannot be blank")
// 	private String status;
// 	@Min(value= 0,message = "Seat Reservation Price must be greater or equal to 0")
// 	private double price;




//   public Long getSeatReservedId() {
//     return this.seatReservedId;
//   }
//   public String getStatus() {
//     return this.status;
//   }

//   public double getPrice() {
//     return this.price;
//   }


//   public void setSeatReservedId(Long seatReservedId) {
//     this.seatReservedId = seatReservedId;
//   }

//   public void setStatus(String status) {
//     this.status = status;
//   }

//   public void setPrice(double price) {
//     this.price = price;
//   }


// }