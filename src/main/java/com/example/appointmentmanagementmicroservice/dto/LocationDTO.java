package com.example.appointmentmanagementmicroservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LocationDTO {
    private Long locationId;
    private String name;
    private int capacity;
    private int floor;
    private String building;
    private List<AppointmentDTO> appointments;

    public LocationDTO( Long locationId, String name, int capacity, int floor, String building, List<AppointmentDTO> appointments) {
        this.locationId = locationId;
        this.name = name;
        this.capacity = capacity;
        this.floor = floor;
        this.building = building;
        this.appointments = appointments;
    }
}
