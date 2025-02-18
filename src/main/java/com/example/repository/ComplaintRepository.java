package com.example.repository;

import com.example.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository  extends JpaRepository<Complaint, Long> {
}
