package com.example.clinicmanagementsystem.repository;

import com.example.clinicmanagementsystem.entity.Patient;
import com.example.clinicmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findByUser(User user);
}
