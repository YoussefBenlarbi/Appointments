package com.example.appointmentmanagementmicroservice.repository;

import com.example.appointmentmanagementmicroservice.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
