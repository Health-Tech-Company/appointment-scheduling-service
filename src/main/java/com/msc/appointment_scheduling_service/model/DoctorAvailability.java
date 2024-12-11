package com.msc.appointment_scheduling_service.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "doctor_availabilities")
public class DoctorAvailability {
    @Id
    private String id;
    private String doctorId;
    private LocalDateTime availableFrom;
    private LocalDateTime availableTo;
}

