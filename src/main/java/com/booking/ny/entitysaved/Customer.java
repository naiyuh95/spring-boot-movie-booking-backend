// package com.booking.ny.entitysaved;
// import java.sql.Date;
// import java.util.Objects;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;

// @Entity
// public class Customer {

//   private @Id @GeneratedValue Long customer_id;
//   private String name;
//   private String username;
//   private String email;

//   Customer() {}

//   Customer(String name,String username,  String email) {
//     this.username = username;
//     this.name = name;
//     this.email = email;
//   }


//   public Long getCustomerId() {
//     return this.customer_id;
//   }

//   public String getName() {
//     return this.name;
//   }

//   public String getUserName() {
//     return this.username;
//   }

//   public String getEmail() {
//     return this.email;
//   }


//   public void setId(Long customer_id) {
//     this.customer_id = customer_id;
//   }

//   public void setName(String name) {
//     this.name = name;
//   }

//   public void setUserName(String username) {
//     this.username = username;
//   }

//   public void setEmail(String email) {
//     this.email = email;
//   }



//   @Override
//   public boolean equals(Object o) {

//     if (this == o)
//       return true;
//     if (!(o instanceof Customer))
//       return false;
//     Customer customer = (Customer) o;
//     return Objects.equals(this.customer_id, customer.customer_id) && Objects.equals(this.name, customer.name)
//         && Objects.equals(this.username, customer.username) && Objects.equals(this.email, customer.email);

//   }

//   @Override
//   public int hashCode() {
//     return Objects.hash(this.customer_id, this.name, this.username, this.email);
//   }

//   @Override
//   public String toString() {
//     return "Customer{" + "Customer ID=" + this.customer_id + ", name='" + this.name + '\'' + ", Username='" + this.username + '\'' 
//     + ", Email ='" + this.email + '}';
//   }
// }