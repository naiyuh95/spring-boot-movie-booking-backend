// package com.booking.ny.entitysaved;
// import java.sql.Date;
// import java.util.Objects;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;

// @Entity
// public class MovieShowReservationSeat {

//   private @Id @GeneratedValue Long id;
//   private String name;
//   private Date dob;
//   private Date dateJoined;
//   private int salary;


//   MovieShowReservationSeat() {}

//   MovieShowReservationSeat(String name, Date dob,Date dateJoined,int salary) {

//     this.name = name;
//     this.dob = dob;
//     this.dateJoined = dateJoined;
//     this.salary = salary;
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
//     if (!(o instanceof ShowSeat))
//       return false;
//     ShowSeat showSeat = (ShowSeat) o;
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
//     return "ShowSeat{" + "id=" + this.id + ", name='" + this.name + '\'' + ", Date Of Birth='" + this.dob + '\'' 
//     + ", Date Joined ='" + this.dateJoined + ", Salary ='" + this.salary  + '}';
//   }
// }