package com.example.jwtsecurity.repository;

import com.example.jwtsecurity.model.CustomerTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTaskRepository extends JpaRepository<CustomerTask, Long> {
}
