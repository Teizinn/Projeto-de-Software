package com.example.ledcontroller.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LedLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime timestamp = LocalDateTime.now();

    public LedLog() {}

    public LedLog(String status) {
        this.status = status;
    }

    // Getters and Setters
}