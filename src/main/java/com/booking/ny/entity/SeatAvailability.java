// package com.booking.ny.entity;
// import java.util.Objects;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.GenerationType;
// import javax.persistence.Column;
// import javax.persistence.Table;

// import org.hibernate.annotations.NotFound;
// import org.hibernate.annotations.NotFoundAction;

// @Table(name = "seat_availability")
// @Entity
// public class SeatAvailability {

//   @Id 
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   @Column(name = "seat_availability_id", unique = true, nullable = false)
//   private Long seatAvailabilityId;

//   @Column(name = "status", unique = false, nullable = false, length = 50)
//   private String status;

//   @Column(name = "price", unique = false, nullable = false)
//   private double price;

//   @ManyToOne
//   @NotFound(action=NotFoundAction.IGNORE)
//   @JoinColumn(name="reservation_id")
//   private Reservation reservation;

//   @ManyToOne    
//   @JoinColumn(name="seat_id")
//   private Seat seat;

//   public SeatAvailability(){}
  
//   public SeatAvailability(String status,double price) {

//     this.status = status;
//     this.price = price;
//   }

//   public Long getSeatReservedId() {
//     return this.seatReservedId;
//   }
//   public String getStatus() {
//     return this.status;
//   }

//   public double getPrice() {
//     return this.price;
//   }

//   public Reservation getReservation() {
//     return this.reservation;
//   }

//   public Seat getSeat() {
//     return this.seat;
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

//   public void setReservation(Reservation reservation) {
//     this.reservation = reservation;
//   }

//   public void setSeat(Seat seat) {
//     this.seat = seat;
//   }




//   @Override
//   public boolean equals(Object o) {

//     if (this == o)
//       return true;
//     if (!(o instanceof SeatReserved))
//       return false;
//       SeatReserved seatReserved = (SeatReserved) o;
//     return Objects.equals(this.seatReservedId, seatReserved.seatReservedId) && Objects.equals(this.status, seatReserved.status)
//         && Objects.equals(this.price, seatReserved.price) ; 
//   }

//   @Override
//   public int hashCode() {
//     return Objects.hash(this.seatReservedId, this.status, this.price);
//   }

//   @Override
//   public String toString() {
//     return "Seat{" + "id=" + this.seatReservedId + ", Seat Status='" + this.status + '\'' + ", Seat Total Price='" + this.price +  '}';
//   }
// }