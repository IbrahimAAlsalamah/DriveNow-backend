package com.example.repository;

import com.example.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository  extends JpaRepository<Branch, Long> {

    List<Branch> findByCity(String branchCity);
    Branch findByEmail(String email);
}
