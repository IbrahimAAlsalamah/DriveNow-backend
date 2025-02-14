package com.example.repository;

import com.example.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT count(*) FROM booking WHERE start_date NOT BETWEEN ?1 AND ?2 OR end_date NOT BETWEEN ?1 AND ?2 ", nativeQuery = true)
    int checkAvailbilty(Date startDate, Date endDate);

}
