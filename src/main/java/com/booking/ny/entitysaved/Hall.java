// package com.booking.ny.entitysaved;
// import java.sql.Date;
// import java.util.Objects;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;

// @Entity
// public class Hall {

//   private @Id @GeneratedValue Long hall_id;
//   private String hall_name;



//   Hall() {}

//   Hall(String hall_name) {

//     this.hall_name = hall_name;

//   }

//   public Long getHallId() {
//     return this.hall_id;
//   }

//   public String getHallName() {
//     return this.hall_name;
//   }



//   public void setHallId(Long hall_id) {
//     this.hall_id = hall_id;
//   }

//   public void setHallName(String hall_name) {
//     this.hall_name = hall_name;
//   }


//   @Override
//   public boolean equals(Object o) {

//     if (this == o)
//       return true;
//     if (!(o instanceof Hall))
//       return false;
//       Hall hall = (Hall) o;
//     return Objects.equals(this.hall_id, hall.hall_id) && Objects.equals(this.hall_name, hall.hall_name);
//   }

//   @Override
//   public int hashCode() {
//     return Objects.hash(this.hall_id, this.hall_name);
//   }

//   @Override
//   public String toString() {
//     return "ShowSeat{" + "id=" + this.hall_id + ", name='" + this.hall_name +'}';
//   }
// }