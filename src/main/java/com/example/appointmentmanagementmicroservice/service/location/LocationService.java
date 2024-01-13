package com.example.appointmentmanagementmicroservice.service.location;

import com.example.appointmentmanagementmicroservice.dto.LocationDTO;
import com.example.appointmentmanagementmicroservice.dto.PatientDTO;

import java.util.List;

public interface LocationService  {
    LocationDTO createLocation(LocationDTO locationDTO);
    LocationDTO updateLocation(LocationDTO locationDTO,Long id);
    LocationDTO getLocationById(Long locationId);
    List<LocationDTO> getLocations();
    void deleteLocation(Long locationId);
}
