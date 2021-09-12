package com.booking.ny.repository;
import java.util.*;

import com.booking.ny.entity.Seat;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query(value="Select s from Seat s Join s.movie m where m.movieId = ?1")
    List<Seat> getSeatsByMovieId(int movieId);
    

}

