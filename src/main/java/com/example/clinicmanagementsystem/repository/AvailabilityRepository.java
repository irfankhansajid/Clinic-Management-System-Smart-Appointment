package com.example.clinicmanagementsystem.repository;

import com.example.clinicmanagementsystem.entity.Availability;
import com.example.clinicmanagementsystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability,Long> {
    List<Availability> findByDoctorAndDayOfWeekAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
            Doctor doctor,
            DayOfWeek dayOfWeek,
            LocalTime requestedStart,
            LocalTime requestedEnd
    );
}
