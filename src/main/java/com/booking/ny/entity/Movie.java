package com.booking.ny.entity;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Movie")
public class Movie {

   
  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "movie_id", unique = true, nullable = false)
  private int movieId;

  @Column(name = "movie_name", unique = true, nullable = false, length = 50)
  private String movieName;

  @Column(name = "description", unique = false, nullable = false, length = 200)
  private String description;

  @Column(name = "duration", unique = false, nullable = false)
  private int duration;

  @Column(name = "genre", unique = false, nullable = false, length = 50)
  private String genre;

  @Column(name = "start_time", unique = false, nullable = false)
  private Timestamp startTime;

  @Column(name = "release_date", unique = false, nullable = false)
  private Date releaseDate;

  @Column(name = "movie_poster_link", unique = false, nullable = false, length = 200)
  private String moviePosterLink;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
  private List<Seat> seatList;
  

  public Movie(){}

  public Movie(String movieName,String description,int duration,String genre, Date releaseDate, Timestamp startTime,String moviePosterLink) {

    this.movieName = movieName;
    this.description = description;
    this.duration = duration;
    this.genre = genre;
    this.releaseDate = releaseDate;
    this.startTime = startTime;
    this.moviePosterLink = moviePosterLink;
  }

  public int getMovieId() {
    return this.movieId;
  }

  public String getMovieName() {
    return this.movieName;
  }

  public String getDescription() {
    return this.description;
  }

  public int getDuration() {
    return this.duration;
  }

  public String getGenre() {
    return this.genre;
  }

  public String getMoviePosterLink() {
    return this.moviePosterLink;
  }

  public Date getReleaseDate() {
    return this.releaseDate;
  }

  public Timestamp getStartTime() {
    return this.startTime;
  }


  public List<Seat> getSeats() {
    return this.seatList;
  }



  public void setMovieId(int movieId) {
    this.movieId = movieId;
  }

  public void setMovieName(String movieName) {
    this.movieName = movieName;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public void setStartTime(Timestamp startTime) {
    this.startTime = startTime;
  }
  
  public void setSeats(List<Seat> seatList) {
    this.seatList = seatList;
  }

  public void setMoviePosterLink(String moviePosterLink) {
    this.moviePosterLink =  moviePosterLink;
  }

}