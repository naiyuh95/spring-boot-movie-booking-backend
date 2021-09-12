package com.booking.ny.entity;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Customer")
public class Customer {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id", unique = true, nullable = false)
  private Long customerId;

  @Column(name = "customer_name", unique = false, nullable = false, length = 50)
  private String customerName;

  @Column(name = "contact_number", unique = false, nullable = false)
  private int contactNumber;

  @Column(name = "email", unique = true, nullable = false, length = 50)
  private String email;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
  private List<Reservation> reservationList;

  public Customer(){}

  public Customer(String customerName,int contactNumber,  String email) {
    this.contactNumber = contactNumber;
    this.customerName = customerName;
    this.email = email;
  }

  public Customer(String customerName,int contactNumber,  String email, List<Reservation> reservationList) {
    this.contactNumber = contactNumber;
    this.customerName = customerName;
    this.email = email;
    this.reservationList = reservationList;
  }

  
  public Long getCustomerId() {
    return this.customerId;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public int getContactNumber() {
    return this.contactNumber;
  }

  public String getEmail() {
    return this.email;
  }

  public List<Reservation> getReservationList() {
    return this.reservationList;
  }



  public void setId(Long customerId) {
    this.customerId = customerId;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public void setContactNumber(int contactNumber) {
    this.contactNumber = contactNumber;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  
  public void setReservationList(List<Reservation> reservationList) {
    this.reservationList = reservationList;
  }



}