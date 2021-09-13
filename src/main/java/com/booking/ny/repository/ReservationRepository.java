package com.booking.ny.repository;
import java.sql.Timestamp;
import java.util.*;

import javax.transaction.Transactional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import com.booking.ny.entity.Reservation;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Transactional
    @Query(value="select * from reservation r where r.seat_id in (:seatIdList) and r.reservation_status = 'OPEN' for update",nativeQuery =true)
    List<Reservation> lockSeatsForUpdates(@Param("seatIdList") List<Long> seatIdList);


    @Transactional
    @Query(value="select * from reservation r where r.seat_id in (:seatIdList) and r.reservation_status = 'OPEN' for update",nativeQuery =true)
    List<Reservation> lockSeatsForUpdate(@Param("seatIdList") List<Long> seatIdList);

    @Modifying
    @Transactional
    @Query(value="update reservation r set r.reservation_status = 'PENDING', r.reservation_start_timestamp = :now ,  r.reservation_end_timestamp = :expire where r.seat_id in (:seatIdList) and r.reservation_status = 'OPEN' ",nativeQuery =true)
    void updateSeatsToBlocked(@Param("seatIdList") List<Long> seatIdList, @Param("now") Timestamp now, @Param("expire") Timestamp expire);

    @Modifying
    @Query(value="update reservation r set r.reservation_status = 'OPEN', r.reservation_start_timestamp = NULL ,  r.reservation_end_timestamp = NULL where r.reservation_end_timestamp < now() and r.reservation_status = 'PENDING'",nativeQuery =true)
    int clearExpiredBlockedReservations();

    @Modifying
    @Query(value="update reservation  r set r.reservation_status = 'CONFIRMED' , r.customer_id = :customerId, r.reservation_end_timestamp = NULL,r.reservation_start_timestamp = NULL,r.reservation_confirmed_date = :now where r.seat_id in (:seatIdList) and r.reservation_status = 'PENDING'",nativeQuery =true)
    void confirmBooking(@Param("seatIdList") List<Long> seatIdList,@Param("customerId") long customerId,@Param("now") Timestamp now);

    
    List<Reservation> findAll();

}