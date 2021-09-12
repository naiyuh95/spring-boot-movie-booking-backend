// package com.booking.ny.entitysaved;
// import java.sql.Date;
// import java.util.Objects;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;

// @Entity
// public class Movie {

//   private @Id @GeneratedValue Long movie_id;
//   private String movie_name;
//   private String description;
//   private int duration;
//   private String genre;
//   private Date release_date;


//   Movie() {}

//   Movie(String movie_name,String description,int duration,String genre, Date release_date) {

//     this.movie_name = movie_name;
//     this.description = description;
//     this.duration = duration;
//     this.genre = genre;
//     this.release_date = release_date;
//   }

//   public Long getMovieId() {
//     return this.movie_id;
//   }

//   public String getMovieName() {
//     return this.movie_name;
//   }

//   public String getDescription() {
//     return this.description;
//   }

//   public int getDuration() {
//     return this.duration;
//   }

//   public String getGenre() {
//     return this.genre;
//   }

//   public Date getReleaseDate() {
//     return this.release_date;
//   }



//   public void setMovieId(Long movie_id) {
//     this.movie_id = movie_id;
//   }

//   public void setMovieName(String movie_name) {
//     this.movie_name = movie_name;
//   }

//   public void setDescription(String description) {
//     this.description = description;
//   }

//   public void setDuration(int duration) {
//     this.duration = duration;
//   }

//   public void setGenre(String genre) {
//     this.genre = genre;
//   }

//   public void setReleaseDate(Date release_date) {
//     this.release_date = release_date;
//   }
  
//   @Override
//   public boolean equals(Object o) {

//     if (this == o)
//       return true;
//     if (!(o instanceof Movie))
//       return false;
//       Movie movie = (Movie) o;
//     return Objects.equals(this.movie_id, movie.movie_id) && Objects.equals(this.movie_name, movie.movie_name)
//         && Objects.equals(this.description, movie.description) && Objects.equals(this.duration, movie.duration) 
//         && Objects.equals(this.genre, movie.genre)&& Objects.equals(this.release_date, movie.release_date);
//   }

//   @Override
//   public int hashCode() {
//     return Objects.hash(this.movie_id, this.movie_name, this.description, this.duration, this.genre,this.release_date);
//   }

//   @Override
//   public String toString() {
//     return "Movie{" + "id=" + this.movie_id + ", name='" + this.movie_name + '\'' + ", Description='" + this.description + '\'' 
//     + ", Duration ='" + this.duration + '\'' + ", Genre ='" + this.genre   + '\'' + ", Release Date ='"  + this.release_date   + '}';
//   }
// }