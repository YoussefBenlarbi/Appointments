package com.example.appointmentmanagementmicroservice.mapper;

import com.example.appointmentmanagementmicroservice.dto.LocationDTO;
import com.example.appointmentmanagementmicroservice.entity.Location;

import java.util.List;
import java.util.stream.Collectors;

public class LocationMapper {

    private static void mapToDTO(Location source, LocationDTO target) {
        target.setLocationId(source.getLocationId());
        target.setName(source.getName());
        target.setCapacity(source.getCapacity());
        target.setFloor(source.getFloor());
        target.setBuilding(source.getBuilding());
    }

    private static void mapToEntity(LocationDTO source, Location target) {
        target.setLocationId(source.getLocationId());
        target.setName(source.getName());
        target.setCapacity(source.getCapacity());
        target.setFloor(source.getFloor());
        target.setBuilding(source.getBuilding());
    }
    public static LocationDTO toDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        mapToDTO(location, locationDTO);

        // Map appointments if not null
        if (location.getAppointments() != null) {
            locationDTO.setAppointments(location.getAppointments().stream()
                    .map(AppointmentMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return locationDTO;
    }

    public static Location toEntity(LocationDTO locationDTO) {
        Location location = new Location();
        mapToEntity(locationDTO, location);

        // Map appointments if not null
        if (locationDTO.getAppointments() != null) {
            location.setAppointments(locationDTO.getAppointments().stream()
                    .map(AppointmentMapper::toEntity)
                    .collect(Collectors.toList()));
        }

        return location;
    }
    public static List<LocationDTO> toListDTO(List<Location> locations) {
        return locations.stream().map(LocationMapper::toDTO).collect(Collectors.toList());
    }
}
