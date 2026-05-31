package com.example.clinicmanagementsystem.repository;

import com.example.clinicmanagementsystem.entity.Appointment;
import com.example.clinicmanagementsystem.entity.Triage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TriageRepository extends JpaRepository<Triage,Long> {
    Optional<Triage> findByAppointment(Appointment appointment);
}
