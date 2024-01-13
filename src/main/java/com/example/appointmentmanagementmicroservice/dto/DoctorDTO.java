package com.example.appointmentmanagementmicroservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DoctorDTO {
    private Long doctorId;
    private String firstName;
    private String lastName;
    private String specialization;
    private String contactNumber;
    private String email;
    private List<AppointmentDTO> appointments;

    public DoctorDTO(Long doctorId,String firstName, String lastName, String specialization, String contactNumber, String email, List<AppointmentDTO> appointments) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.contactNumber = contactNumber;
        this.email = email;
        this.appointments = appointments;
    }
}
