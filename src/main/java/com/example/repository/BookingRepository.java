package com.example.repository;

import com.example.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT count(*) FROM booking WHERE (car_id = ?1) " +
            "AND (start_date <=?3 AND end_date >=?2 )", nativeQuery = true)
    int checkAvailbilty(Long carID, Date startDate, Date endDate);

}
