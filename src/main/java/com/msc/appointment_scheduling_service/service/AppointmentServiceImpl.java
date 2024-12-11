package com.msc.appointment_scheduling_service.service;

import com.msc.appointment_scheduling_service.model.Appointment;
import com.msc.appointment_scheduling_service.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {


    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(String id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return appointment.orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(String doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> getAppointmentsByPatient(String patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public Appointment updateAppointmentStatus(String id, String status) {
        Appointment appointment = getAppointmentById(id);
        appointment.setStatus(status);
        return appointmentRepository.save(appointment);
    }

    @Override
    public void cancelAppointment(String id) {
        Appointment appointment = getAppointmentById(id);
        appointmentRepository.delete(appointment);
    }
}
