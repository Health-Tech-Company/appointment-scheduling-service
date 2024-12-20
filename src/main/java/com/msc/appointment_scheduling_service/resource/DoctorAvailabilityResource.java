package com.msc.appointment_scheduling_service.resource;

import com.msc.appointment_scheduling_service.model.DoctorAvailability;
import com.msc.appointment_scheduling_service.repository.DoctorAvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/availability")
public class DoctorAvailabilityResource {

    private final DoctorAvailabilityRepository doctorAvailabilityRepository;

    @PostMapping
    public ResponseEntity<DoctorAvailability> addAvailability(@RequestBody DoctorAvailability availability) {
        return ResponseEntity.ok(this.doctorAvailabilityRepository.save(availability));
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<List<DoctorAvailability>> getDoctorAvailability(@PathVariable String doctorId) {
        return ResponseEntity.ok(this.doctorAvailabilityRepository.findByDoctorId(doctorId));
    }
}
