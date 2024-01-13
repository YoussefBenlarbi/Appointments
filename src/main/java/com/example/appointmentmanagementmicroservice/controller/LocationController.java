package com.example.appointmentmanagementmicroservice.controller;


import com.example.appointmentmanagementmicroservice.dto.LocationDTO;

import com.example.appointmentmanagementmicroservice.service.location.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {
    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @GetMapping("/")
    public ResponseEntity<List<LocationDTO>> getLocations() {
        return ResponseEntity.ok(locationService.getLocations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.getLocationById(id));
    }

    @PostMapping("/")
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO) {
        return new ResponseEntity<>(locationService.createLocation(locationDTO), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LocationDTO> updateLocation (@PathVariable Long id , @RequestBody LocationDTO locationDTO)
    {
        return ResponseEntity.ok(locationService.updateLocation(locationDTO,id));
    }

    @DeleteMapping("/{id}")
    public void deleteLocationById(@PathVariable Long id ){
        locationService.deleteLocation(id);

    }

}
