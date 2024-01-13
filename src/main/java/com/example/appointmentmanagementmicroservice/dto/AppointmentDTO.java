package com.example.appointmentmanagementmicroservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentDTO {
    private Long appointmentId;
    private LocalDate date;
    private LocalTime time;
    private int duration;
    private String status;
    private String type;
    private DoctorDTO doctor;
    private PatientDTO patient;
    private LocationDTO location;

    public AppointmentDTO(Long appointmentId, LocalDate date, LocalTime time, int duration, String status, String type, DoctorDTO doctor, PatientDTO patient, LocationDTO location) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.status = status;
        this.type = type;
        this.doctor = doctor;
        this.patient = patient;
        this.location = location;
    }
}

