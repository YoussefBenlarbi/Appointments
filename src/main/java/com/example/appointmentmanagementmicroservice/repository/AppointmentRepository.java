package com.example.appointmentmanagementmicroservice.repository;

import com.example.appointmentmanagementmicroservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
