package com.example.appointmentmanagementmicroservice.service.location;

import com.example.appointmentmanagementmicroservice.dto.LocationDTO;
import com.example.appointmentmanagementmicroservice.entity.Location;
import com.example.appointmentmanagementmicroservice.mapper.LocationMapper;
import com.example.appointmentmanagementmicroservice.repository.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public LocationDTO createLocation(LocationDTO locationDTO) {
        return LocationMapper.toDTO(locationRepository.save(LocationMapper.toEntity(locationDTO)));
    }

    @Override
    public LocationDTO updateLocation(LocationDTO locationDTO, Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Location not found"));
        location.setName(locationDTO.getName());
        location.setCapacity(locationDTO.getCapacity());
        location.setFloor(locationDTO.getFloor());
        location.setBuilding(locationDTO.getBuilding());
        return LocationMapper.toDTO(locationRepository.save(location));
    }

    @Override
    public LocationDTO getLocationById(Long locationId) {
        return LocationMapper.toDTO(locationRepository.findById(locationId).orElseThrow(() -> new EntityNotFoundException("Location not found")));
    }

    @Override
    public List<LocationDTO> getLocations() {
        return LocationMapper.toListDTO(locationRepository.findAll());
    }

    @Override
    public void deleteLocation(Long locationId) {
        locationRepository.deleteById(locationId);
    }
}
