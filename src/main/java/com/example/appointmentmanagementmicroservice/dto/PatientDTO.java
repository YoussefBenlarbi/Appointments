package com.example.appointmentmanagementmicroservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PatientDTO {
    Long patientId;
    String firstName;
    String lastName;
    String dateOfBirth;
    String contactNumber;
    String email;
    String gender;
    List<AppointmentDTO> appointments;
    public PatientDTO( Long patientId,String firstName, String lastName, String dateOfBirth, String contactNumber, String email, String gender, List<AppointmentDTO> appointments) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.email = email;
        this.gender = gender;
        this.appointments = appointments;
    }

}