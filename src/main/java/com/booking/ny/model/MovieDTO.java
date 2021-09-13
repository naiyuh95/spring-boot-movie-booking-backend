package com.booking.ny.model;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {

  @Min(value= 0, message = "Movie id must be greater or equal to 0")
	private long movieId;
	@NotBlank(message = "Movie title cannot be blank")
	private String movieName;
	@NotBlank(message = "Movie description cannot be blank")
	private String description;
	@Min(value= 0,message = "Movie duration must be greater or equal to 0")
	private int duration;
	@NotBlank(message = "Movie genre cannot be blank")
	private String genre;
  @NotNull(message = "Movie start time cannot be null")
  private Timestamp startTime;

  @NotNull(message = "Movie release date cannot be null")
  private Date releaseDate;

  @NotBlank(message = "Movie poster link cannot be blank")
  private String moviePosterLink;


  public Long getMovieId() {
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





  public void setMovieId(Long movieId) {
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

  
  public void setMoviePosterLink(String moviePosterLink) {
    this.moviePosterLink =  moviePosterLink;
  }



}