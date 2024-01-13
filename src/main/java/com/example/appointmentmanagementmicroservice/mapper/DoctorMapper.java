package com.example.appointmentmanagementmicroservice.mapper;

import com.example.appointmentmanagementmicroservice.dto.DoctorDTO;
import com.example.appointmentmanagementmicroservice.entity.Doctor;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorMapper {

    private static void mapEntityToDto(Doctor source, DoctorDTO target) {
        target.setDoctorId(source.getDoctorId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setSpecialization(source.getSpecialization());
        target.setContactNumber(source.getContactNumber());
        target.setEmail(source.getEmail());
    }

    private static void mapDtoToEntity(DoctorDTO source, Doctor target) {
        target.setDoctorId(source.getDoctorId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setSpecialization(source.getSpecialization());
        target.setContactNumber(source.getContactNumber());
        target.setEmail(source.getEmail());
    }

    public static DoctorDTO toDTO(Doctor doctor) {
        DoctorDTO doctorDTO = new DoctorDTO();
        mapEntityToDto(doctor, doctorDTO);

        // Map appointments if not null
//        if (doctor.getAppointments() != null) {
//            doctorDTO.setAppointments(doctor.getAppointments().stream()
//                    .map(AppointmentMapper::toDTO)
//                    .collect(Collectors.toList()));
//        }

        return doctorDTO;
    }

    public static Doctor toEntity(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        mapDtoToEntity(doctorDTO, doctor);

        // Map appointments if not null
//        if (doctorDTO.getAppointments() != null) {
//            doctor.setAppointments(doctorDTO.getAppointments().stream()
//                    .map(AppointmentMapper::toEntity)
//                    .collect(Collectors.toList()));
//        }

        return doctor;
    }
    public static List<Doctor> toListEntity(List<DoctorDTO> doctorDTOList) {
        return doctorDTOList.stream().map(DoctorMapper::toEntity).collect(Collectors.toList());
    }
    public static List<DoctorDTO> toListDTO(List<Doctor> doctorList) {
        return doctorList.stream().map(DoctorMapper::toDTO).collect(Collectors.toList());
    }
}
