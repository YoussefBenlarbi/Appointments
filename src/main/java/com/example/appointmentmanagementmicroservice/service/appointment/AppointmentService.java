package com.example.appointmentmanagementmicroservice.service.appointment;

import com.example.appointmentmanagementmicroservice.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {
    AppointmentDTO createAppointment(AppointmentDTO appointmentDTO);
    AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO,Long id);
    AppointmentDTO getAppointmentById(Long appointmentId);
    List<AppointmentDTO> getAppointments();
    void deleteAppointment(Long appointmentId);


}
