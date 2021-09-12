// package com.booking.ny.interfaces;
// import java.util.*;

// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;
// import javax.transaction.Transactional;

// import com.booking.ny.entity.Reservation;
// import com.booking.ny.model.SeatDTO;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;



// @Repository
// public class CustomReservationRepositoryImpl implements CustomReservationRepository {
//     @PersistenceContext
//     private EntityManager entityManager;

    
//     int selectSeatsForTransaction(List<SeatDTO> seatList);


// @Query(value="select * from student where roll_no in (:rollNos)",native =true)
// List<Object[]> selectStudents(@Param("rollNos") List<Integer> rollNos);

//     void updateSeatsForBlocking(List<SeatDTO> seatList);


    
// }