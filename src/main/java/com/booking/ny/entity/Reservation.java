package com.booking.ny.entity;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "Reservation")
public class Reservation {

  
  @Id  
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reservation_id", unique = true, nullable = false)
  private  Long reservationId;

  @Column(name = "reservation_confirmed_date", unique = false, nullable = true)
  private Timestamp reservationConfirmedTimeStamp;

  @Column(name = "reservation_start_timestamp", unique = false, nullable = true)
  private Timestamp reservationStartTimeStamp;

  @Column(name = "reservation_end_timestamp", unique = false, nullable = true)
  private Timestamp reservationEndTimeStamp;
  
  @Column(name = "reservation_status", unique = false, nullable = false,length = 50)
  private String reservationStatus;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn( name="customer_id", nullable=true )
  private Customer customer;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn( name="seat_id", nullable=false )
  private Seat seat;


  public Reservation(){}

  //when creating a seat, create a reservation with status Open
  public Reservation(String reservationStatus, Seat seat) {

    this.reservationStatus = reservationStatus;
    this.seat = seat;

  }

  //when creating a seat, create a reservation with status Blocked 
  public Reservation(String reservationStatus,Seat seat, Timestamp reservationStartTimeStamp,Timestamp reservationEndTimeStamp) {

    this.reservationStatus = reservationStatus;
    this.reservationStartTimeStamp = reservationStartTimeStamp;
    this.seat = seat;
    this.reservationEndTimeStamp = reservationEndTimeStamp;


  }

  //when creating a seat, create a reservation with status Confirmed 
  public Reservation(String reservationStatus, Timestamp reservationConfirmedTimeStamp, Customer customer,Seat seat) {

    this.reservationStatus = reservationStatus;

    this.seat = seat;
    this.customer = customer;


  }

  public long getReservationId() {
    return this.reservationId;
  }


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

  public Customer getCustomer() {
    return this.customer;
  }

  public Seat getSeat() {
    return this.seat;
  }

  
  public void setReservationId(long reservationId) {
    this.reservationId = reservationId;
  }

  public void setReservationStatus(String reservationStatus) {
    this.reservationStatus = reservationStatus;
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

  public void setCustomer(Seat seat) {
    this.seat = seat;
  }


  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  // public List<SeatReserved> getSeatReserved() {
  //   return this.seatReservedList;
  // }

  // public void setSeatReserved(List<SeatReserved> seatReserved) {
  //   this.seatReservedList = seatReservedList;
  // }




  // @Override
  // public boolean equals(Object o) {

  //   if (this == o)
  //     return true;
  //   if (!(o instanceof Reservation))
  //     return false;
  //   Reservation reservation = (Reservation) o;
  //   return Objects.equals(this.reservationConfirmedTimeStamp, reservation.reservationConfirmedTimeStamp) &&
  //   Objects.equals(this.reservationStartTimeStamp, reservation.reservationStartTimeStamp) &&
  //   Objects.equals(this.reservationEndTimeStamp, reservation.reservationEndTimeStamp) &&
  //   Objects.equals(this.reservationStatus, reservation.reservationStatus) &&
  //   Objects.equals(this.reservationConfirmedTimeStamp, reservation.reservationConfirmedTimeStamp); 
  // }



  // @Override
  // public int hashCode() {
  //   return Objects.hash(this.reservationTimeStamp);
  // }

  // @Override
  // public String toString() {
  //   return "Reservation{" + "id=" + this.reservationId + ", Reservation Date='" + this.reservationTimeStamp +  '}';
  // }
}