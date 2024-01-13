package com.example.appointmentmanagementmicroservice.service.appointment;

import com.example.appointmentmanagementmicroservice.dto.AppointmentDTO;
import com.example.appointmentmanagementmicroservice.entity.Appointment;
import com.example.appointmentmanagementmicroservice.mapper.AppointmentMapper;
import com.example.appointmentmanagementmicroservice.mapper.DoctorMapper;
import com.example.appointmentmanagementmicroservice.mapper.LocationMapper;
import com.example.appointmentmanagementmicroservice.repository.AppointmentRepository;
import com.example.appointmentmanagementmicroservice.repository.DoctorRepository;
import com.example.appointmentmanagementmicroservice.repository.LocationRepository;
import com.example.appointmentmanagementmicroservice.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import static com.example.appointmentmanagementmicroservice.mapper.AppointmentMapper.mappingEntitytoDTOAppointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository, LocationRepository locationRepositoryRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.locationRepository = locationRepositoryRepository;
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        try {
            Appointment appointment = appointmentRepository.save(AppointmentMapper.toEntity(appointmentDTO));
            if (appointmentDTO.getDoctor() != null) {
                appointment.setDoctor(doctorRepository.findById(appointmentDTO.getDoctor().getDoctorId())
                        .orElseThrow(() -> new EntityNotFoundException("[WARNING] -- Doctor Not Found !!! ------------------")));
            }
            if (appointmentDTO.getPatient() != null) {
                appointment.setPatient(patientRepository.findById(appointmentDTO.getPatient().getPatientId())
                        .orElseThrow(() -> new EntityNotFoundException("[WARNING] -- Patient Not Found !!! ------------------")));
            }
            if (appointmentDTO.getLocation() != null) {
                appointment.setLocation(locationRepository.findById(appointmentDTO.getLocation().getLocationId())
                        .orElseThrow(() -> new EntityNotFoundException("[WARNING] -- Location Not Found !!! ------------------")));
            }
            return AppointmentMapper.toDTO(appointment);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create appointment. Doctor not found.");
        }
    }


    @Override
    public AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO, Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("[WARNING] Appointment not found to be updated !!!"));
//        mappingEntitytoDTOAppointment(appointmentDTO, appointment);
        appointment.setDate(appointmentDTO.getDate());
        appointment.setTime(appointmentDTO.getTime());
        appointment.setDuration(appointmentDTO.getDuration());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setType(appointmentDTO.getType());

        if (appointmentDTO.getDoctor() != null) {
            appointment.setDoctor(DoctorMapper.toEntity(appointmentDTO.getDoctor()));
        }
        if (appointmentDTO.getPatient() != null) {
            appointment.setDoctor(DoctorMapper.toEntity(appointmentDTO.getDoctor()));
        }
        if (appointmentDTO.getLocation() != null) {
            appointment.setLocation(LocationMapper.toEntity(appointmentDTO.getLocation()));
        }
        return AppointmentMapper.toDTO(appointmentRepository.save(appointment));
    }

    @Override
    public AppointmentDTO getAppointmentById(Long id) {
        return AppointmentMapper.toDTO(appointmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("[WARNING] Appointment Not Found !!!")));
    }

    @Override
    public List<AppointmentDTO> getAppointments() {
        return AppointmentMapper.ToListDTO(appointmentRepository.findAll());
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
