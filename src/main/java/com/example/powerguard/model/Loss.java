package com.example.powerguard.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "losses")
public class Loss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private Integer affectedHomes;
    private Integer affectedBusinesses;
    private String description;
    private Double estimatedLoss;
    private LocalDateTime timestamp;

    public Loss() {
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Integer getAffectedHomes() { return affectedHomes; }
    public void setAffectedHomes(Integer affectedHomes) { this.affectedHomes = affectedHomes; }

    public Integer getAffectedBusinesses() { return affectedBusinesses; }
    public void setAffectedBusinesses(Integer affectedBusinesses) { this.affectedBusinesses = affectedBusinesses; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getEstimatedLoss() { return estimatedLoss; }
    public void setEstimatedLoss(Double estimatedLoss) { this.estimatedLoss = estimatedLoss; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
} 