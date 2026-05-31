package com.example.clinicmanagementsystem.repository;

import com.example.clinicmanagementsystem.entity.Appointment;
import com.example.clinicmanagementsystem.entity.AppointmentStatus;
import com.example.clinicmanagementsystem.entity.Doctor;
import com.example.clinicmanagementsystem.entity.Triage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByDoctorAndAppointmentDateAndStartTimeLessThanAndEndTimeGreaterThanAndStatus(
            Doctor doctor,
            LocalDate appointmentDate,
            LocalTime requestedEndTime,
            LocalTime requestedStartTime,
            AppointmentStatus status
    );
}
