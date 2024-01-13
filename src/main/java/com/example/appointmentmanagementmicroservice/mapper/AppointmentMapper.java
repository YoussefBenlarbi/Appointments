package com.example.appointmentmanagementmicroservice.mapper;

import com.example.appointmentmanagementmicroservice.dto.AppointmentDTO;
import com.example.appointmentmanagementmicroservice.entity.Appointment;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentMapper {
    public static AppointmentDTO toDTO(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setAppointmentId(appointment.getAppointmentId());
        appointmentDTO.setDate(appointment.getDate());
        if (appointment.getTime() != null) {
            appointmentDTO.setTime(LocalTime.parse(String.valueOf(appointment.getTime())));
        }
//        appointmentDTO.setTime(LocalTime.parse(String.valueOf(appointment.getTime())));
        appointmentDTO.setDuration(appointment.getDuration());
        appointmentDTO.setStatus(appointment.getStatus());
        appointmentDTO.setType(appointment.getType());
        if (appointment.getDoctor() != null) {
            appointmentDTO.setDoctor(DoctorMapper.toDTO(appointment.getDoctor()));
        }
        if (appointment.getPatient() != null) {
            appointmentDTO.setPatient(PatientMapper.toDTO(appointment.getPatient()));
        }
        if (appointment.getLocation() != null) {
            appointmentDTO.setLocation(LocationMapper.toDTO(appointment.getLocation()));
        }
        return appointmentDTO;
    }

    public static List<AppointmentDTO> ToListDTO(List<Appointment> appointments) {
        return appointments.stream().map(AppointmentMapper::toDTO).collect(Collectors.toList());
    }

    public static Appointment toEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(appointmentDTO.getAppointmentId());
        appointment.setDate(appointmentDTO.getDate());
        if (appointment.getTime() != null) {
            appointment.setTime(LocalTime.parse(String.valueOf(appointmentDTO.getTime())));
        }
//        appointment.setTime(LocalTime.parse(String.valueOf(appointmentDTO.getTime())));
        appointment.setDuration(appointmentDTO.getDuration());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setType(appointmentDTO.getType());
        if (appointmentDTO.getDoctor() != null) {
            appointment.setDoctor(DoctorMapper.toEntity(appointmentDTO.getDoctor()));
        }
        if (appointmentDTO.getPatient() != null) {
            appointment.setPatient(PatientMapper.toEntity(appointmentDTO.getPatient()));
        }
        if (appointmentDTO.getLocation() != null) {
            appointment.setLocation(LocationMapper.toEntity(appointmentDTO.getLocation()));
        }
        return appointment;
    }

    public static List<Appointment> ToListEntity(List<AppointmentDTO> appointmentDTOs) {
        return appointmentDTOs.stream().map(AppointmentMapper::toEntity).collect(Collectors.toList());
    }
}