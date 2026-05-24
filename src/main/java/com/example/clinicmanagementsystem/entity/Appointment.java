package com.example.clinicmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "patient_id")
    @ManyToOne
    @ToString.Exclude
    private Patient patient;


    @JoinColumn(name = "doctor_id")
    @ManyToOne
    @ToString.Exclude
    private Doctor doctor;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Triage triage;

    private LocalDate appointmentDate;

    private LocalTime startTime;

    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    public enum AppointmentStatus {
        SCHEDULED, CANCELLED, RESCHEDULED, COMPLETED, NO_SHOW
    }

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}

