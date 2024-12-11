package com.msc.appointment_scheduling_service.repository;

import com.msc.appointment_scheduling_service.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {
    List<Appointment> findByDoctorId(String doctorId);

    List<Appointment> findByPatientId(String patientId);
}
