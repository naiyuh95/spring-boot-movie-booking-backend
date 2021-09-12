package com.booking.ny.repository;
import java.util.*;

import com.booking.ny.entity.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAll();

    @Query(value ="Select * from Movie where movie_name = :movieName order by start_time desc" ,nativeQuery = true)
    List<Movie> findMovieByName(@Param("movieName") String movieName);

}