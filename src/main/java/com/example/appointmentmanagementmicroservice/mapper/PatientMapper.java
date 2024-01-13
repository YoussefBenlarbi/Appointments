package com.example.appointmentmanagementmicroservice.mapper;

import com.example.appointmentmanagementmicroservice.dto.PatientDTO;
import com.example.appointmentmanagementmicroservice.entity.Patient;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PatientMapper {

    private static void mapEntityToDto(Patient source, PatientDTO target) {
        target.setPatientId(source.getPatientId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setContactNumber(source.getContactNumber());
        target.setEmail(source.getEmail());
        if (source.getDateOfBirth() != null) {
            target.setDateOfBirth(String.valueOf(source.getDateOfBirth()));
        }
        target.setGender(source.getGender());
    }

    private static void mapDtoToEntity(PatientDTO source, Patient target) {
        target.setPatientId(source.getPatientId());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setContactNumber(source.getContactNumber());
        target.setEmail(source.getEmail());
        if (source.getDateOfBirth() != null) {
            target.setDateOfBirth(LocalDate.parse(String.valueOf(source.getDateOfBirth())));
        }
        target.setGender(source.getGender());
    }

    public static PatientDTO toDTO(Patient patient) {
        PatientDTO patientDTO = new PatientDTO();
        mapEntityToDto(patient, patientDTO);

        // Map appointments if not null
//        if (patient.getAppointments() != null) {
//            patientDTO.setAppointments(patient.getAppointments().stream()
//                    .map(AppointmentMapper::toDTO)
//                    .collect(Collectors.toList()));
//        }

        return patientDTO;
    }

    public static Patient toEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        mapDtoToEntity(patientDTO, patient);

        // Map appointments if not null
//        if (patientDTO.getAppointments() != null) {
//            patient.setAppointments(patientDTO.getAppointments().stream()
//                    .map(AppointmentMapper::toEntity)
//                    .collect(Collectors.toList()));
//        }

        return patient;
    }
    public static List<Patient> toListEntity(List<PatientDTO> patientDTOList) {
        return patientDTOList.stream().map(PatientMapper::toEntity).collect(Collectors.toList());
    }
    public static List<PatientDTO> toListDTO(List<Patient> patientList) {
        return patientList.stream().map(PatientMapper::toDTO).collect(Collectors.toList());
    }
}
