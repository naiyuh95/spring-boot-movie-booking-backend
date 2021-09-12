package com.booking.ny.entity;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name = "Seat")
@Entity
public class Seat {

  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "seat_id", unique = true, nullable = false)
  private int seatId;

  @Column(name = "seat_type", unique = false, nullable = false, length = 50)
  private String seatType;


  @Column(name = "seat_number", unique = false, nullable = false)
  private int seatNumber;

  @Column(name = "seat_name", unique = false, nullable = false)
  private String seatName;


  @Column(name = "price", unique = false, nullable = false)
  private double price;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "seat")
  private List<Reservation> reservation;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn( name="movie_id", nullable=false )
  private Movie movie;

  // @OneToMany(cascade=CascadeType.ALL)
  // @JoinColumn(name="seat_reserved_id")
  // private List<SeatReserved> seatReserved;

    // @Column(name = "seat_columns", unique = false, nullable = false)
  // private int seatColumns;

  // @Column(name = "status", unique = false, nullable = false, length = 50)
  // private String status;


  // @Column(name = "seat_rows", unique = false, nullable = false)
  // private int seatRows;



  public Seat(){}

  public Seat(String seatType, int seatNumber,double price, Movie movie, String seatName) {

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
  
  // public int getSeatColumns() {
  //   return this.seatColumns;
  // }

  // public String getStatus() {
  //   return this.status;
  // }

  public double getPrice() {
    return this.price;
  }

  public String getSeatName() {
    return this.seatName;
  }


  // public int getSeatRows() {
  //   return this.seatRows;
  // }

  public List<Reservation> getReservation() {
    return this.reservation;
  }

  public Movie movie() {
    return this.movie;
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

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setReservation(List<Reservation> reservation) {
    this.reservation = reservation;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Seat))
      return false;
    Seat seat = (Seat) o;
    return Objects.equals(this.seatId, seat.seatId) && Objects.equals(this.seatType, seat.seatType)
        && Objects.equals(this.seatNumber, seat.seatNumber) ; 
  }

  // @Override
  // public int hashCode() {
  //   return Objects.hash(this.seatId, this.seatType, this.seatNumber);
  // }

  // @Override
  // public String toString() {
  //   return "Seat{" + "id=" + this.seatId + ", Seat Type='" + this.seatType + '\'' + ", Seat Number='" + this.seatNumber + '\'' 
  //   + '}';
  // }
}