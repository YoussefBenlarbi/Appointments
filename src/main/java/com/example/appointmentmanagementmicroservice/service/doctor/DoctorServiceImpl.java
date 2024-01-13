package com.example.appointmentmanagementmicroservice.service.doctor;

import com.example.appointmentmanagementmicroservice.dto.DoctorDTO;
import com.example.appointmentmanagementmicroservice.entity.Doctor;
import com.example.appointmentmanagementmicroservice.mapper.AppointmentMapper;
import com.example.appointmentmanagementmicroservice.mapper.DoctorMapper;
import com.example.appointmentmanagementmicroservice.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import static com.example.doctormanagementmicroservice.mapper.DoctorMapper.mappingEntitytoDTODoctor;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        return DoctorMapper.toDTO(doctorRepository.save(DoctorMapper.toEntity((doctorDTO))));
    }

    @Override
    public DoctorDTO updateDoctor(DoctorDTO doctorDTO, Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("[WARNING] Doctor not found to be updated !!!"));
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setContactNumber(doctorDTO.getContactNumber());
        if (doctor.getAppointments() != null && !doctorDTO.getAppointments().isEmpty()) {
            doctor.setAppointments(doctorDTO.getAppointments().stream()
                    .map(AppointmentMapper::toEntity)
                    .collect(java.util.stream.Collectors.toList()));
        }
        return DoctorMapper.toDTO(doctorRepository.save(doctor));
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        return DoctorMapper.toDTO(doctorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("[WARNING] Doctor Not Found !!!")));
    }

    @Override
    public List<DoctorDTO> getDoctors() {
        return DoctorMapper.toListDTO(doctorRepository.findAll());
    }

    @Override
    public void deleteDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}
