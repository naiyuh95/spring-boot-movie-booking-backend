package com.booking.ny.entity;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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



  public Seat(){}

  public Seat(String seatType, int seatNumber,double price, String seatName) {

    this.seatType = seatType;
    this.seatNumber = seatNumber;
    this.price = price;
    this.seatName = seatName;
  }
  public Seat(String seatType, int seatNumber,double price, Movie movie, String seatName) {

    this.seatType = seatType;
    this.seatNumber = seatNumber;
    this.price = price;
    this.seatName = seatName;
    this.movie = movie;
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



}