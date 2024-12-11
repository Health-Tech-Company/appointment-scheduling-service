package com.msc.appointment_scheduling_service.service;

import com.msc.appointment_scheduling_service.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment bookAppointment(Appointment appointment);

    Appointment getAppointmentById(String id);

    List<Appointment> getAppointmentsByDoctor(String doctorId);

    List<Appointment> getAppointmentsByPatient(String patientId);

    Appointment updateAppointmentStatus(String id, String status);

    void cancelAppointment(String id);
}
