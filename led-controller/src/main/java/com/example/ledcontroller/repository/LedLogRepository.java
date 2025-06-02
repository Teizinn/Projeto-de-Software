package com.example.ledcontroller.repository;

import com.example.ledcontroller.model.LedLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LedLogRepository extends JpaRepository<LedLog, Long> {}