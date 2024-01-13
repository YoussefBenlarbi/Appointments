package com.example.appointmentmanagementmicroservice.service.patient;

import com.example.appointmentmanagementmicroservice.dto.PatientDTO;
import com.example.appointmentmanagementmicroservice.entity.Patient;
import com.example.appointmentmanagementmicroservice.mapper.AppointmentMapper;
import com.example.appointmentmanagementmicroservice.mapper.PatientMapper;
import com.example.appointmentmanagementmicroservice.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDTO createPatient(PatientDTO patientDTO) {
        return PatientMapper.toDTO(patientRepository.save(PatientMapper.toEntity((patientDTO))));
    }

    @Override
    public PatientDTO updatePatient(PatientDTO patientDTO, Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("[WARNING] Patient not found to be updated !!!"));
        patient.setEmail(patientDTO.getEmail());
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setContactNumber(patientDTO.getContactNumber());
        if (patient.getAppointments() != null && !patientDTO.getAppointments().isEmpty()) {
            patient.setAppointments(patientDTO.getAppointments().stream()
                    .map(AppointmentMapper::toEntity)
                    .collect(java.util.stream.Collectors.toList()));
        }
        return PatientMapper.toDTO(patientRepository.save(patient));
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        return PatientMapper.toDTO(patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("[WARNING] Patient Not Found !!!")));
    }

    @Override
    public List<PatientDTO> getPatients() {
        return PatientMapper.toListDTO(patientRepository.findAll());
    }

    @Override
    public void deletePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }
}
