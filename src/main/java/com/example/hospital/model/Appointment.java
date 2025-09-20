package com.example.hospital.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    private LocalDateTime appointmentTime;
    private String status;
    public Appointment() {}
    public Appointment(Long id, Patient patient, Doctor doctor, LocalDateTime appointmentTime, String status){
        this.id = id; this.patient = patient; this.doctor = doctor; this.appointmentTime = appointmentTime; this.status = status;
    }
    // getters and setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public Patient getPatient(){ return patient; }
    public void setPatient(Patient patient){ this.patient = patient; }
    public Doctor getDoctor(){ return doctor; }
    public void setDoctor(Doctor doctor){ this.doctor = doctor; }
    public LocalDateTime getAppointmentTime(){ return appointmentTime; }
    public void setAppointmentTime(LocalDateTime appointmentTime){ this.appointmentTime = appointmentTime; }
    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }
}
