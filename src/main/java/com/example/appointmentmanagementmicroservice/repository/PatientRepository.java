package com.example.appointmentmanagementmicroservice.repository;

import com.example.appointmentmanagementmicroservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{
}
