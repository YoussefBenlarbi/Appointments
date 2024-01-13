package com.example.appointmentmanagementmicroservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    private String name;
    private int capacity;
    private int floor;
    private String building;
    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<Appointment> appointments;
}
