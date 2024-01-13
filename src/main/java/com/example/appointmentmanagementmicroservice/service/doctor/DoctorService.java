package com.example.appointmentmanagementmicroservice.service.doctor;

import com.example.appointmentmanagementmicroservice.dto.DoctorDTO;

import java.util.List;

public interface DoctorService {
    DoctorDTO createDoctor(DoctorDTO doctorDTO);
    DoctorDTO updateDoctor(DoctorDTO doctorDTO,Long id);
    DoctorDTO getDoctorById(Long doctorId);
    List<DoctorDTO> getDoctors();
    void deleteDoctor(Long doctorId);


}
