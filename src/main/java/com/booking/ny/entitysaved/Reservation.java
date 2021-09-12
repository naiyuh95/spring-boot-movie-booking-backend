// package com.booking.ny.entitysaved;
// import java.sql.Date;
// import java.util.Objects;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;

// @Entity
// public class Reservation {

//   private @Id @GeneratedValue Long reservation_id;
//   private Date reservation_date;
//   private Long customer_id;


//   Reservation() {}

//   Reservation(Date reservation_date, Long customer_id) {

//     this.reservation_date = reservation_date;
//     this.customer_id = customer_id;
//   }

//   public Long getId() {
//     return this.id;
//   }

//   public String getName() {
//     return this.name;
//   }

//   public Date getDOB() {
//     return this.dob;
//   }

//   public Date getDateJoined() {
//     return this.dateJoined;
//   }

//   public int getSalary() {
//     return this.salary;
//   }


//   public void setId(Long id) {
//     this.id = id;
//   }

//   public void setName(String name) {
//     this.name = name;
//   }

//   public void setDOB(Date dob) {
//     this.dob = dob;
//   }

//   public void setDateJoined(Date dateJoined) {
//     this.dateJoined = dateJoined;
//   }

//   public void setSalary(int salary) {
//     this.salary = salary;
//   }

//   @Override
//   public boolean equals(Object o) {

//     if (this == o)
//       return true;
//     if (!(o instanceof Reservation))
//       return false;
//       Reservation showSeat = (Reservation) o;
//     return Objects.equals(this.id, showSeat.id) && Objects.equals(this.name, showSeat.name)
//         && Objects.equals(this.dob, showSeat.dob) && Objects.equals(this.dateJoined, showSeat.dateJoined) 
//         && Objects.equals(this.salary, showSeat.salary);
//   }

//   @Override
//   public int hashCode() {
//     return Objects.hash(this.id, this.name, this.dob, this.dateJoined, this.salary);
//   }

//   @Override
//   public String toString() {
//     return "Reservation{" + "id=" + this.id + ", name='" + this.name + '\'' + ", Date Of Birth='" + this.dob + '\'' 
//     + ", Date Joined ='" + this.dateJoined + ", Salary ='" + this.salary  + '}';
//   }
// }