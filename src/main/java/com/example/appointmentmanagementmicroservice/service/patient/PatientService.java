package com.example.appointmentmanagementmicroservice.service.patient;

import com.example.appointmentmanagementmicroservice.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    PatientDTO createPatient(PatientDTO patientDTO);
    PatientDTO updatePatient(PatientDTO patientDTO,Long id);
    PatientDTO getPatientById(Long patientId);
    List<PatientDTO> getPatients();
    void deletePatient(Long patientId);


}
