package com.example.appointmentmanagementmicroservice.repository;

import com.example.appointmentmanagementmicroservice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
