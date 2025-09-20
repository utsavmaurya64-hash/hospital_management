package com.example.hospital;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.hospital.model.Patient;
import com.example.hospital.model.Doctor;
import com.example.hospital.model.Appointment;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.AppointmentRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Preload sample data so app works out-of-the-box
//    @Bean
//    CommandLineRunner initData(PatientRepository patientRepo, DoctorRepository doctorRepo, AppointmentRepository appRepo){
//        return args -> {
//            Patient p1 = new Patient(null, "Rahul Sharma", 28, "Male", "rahul@example.com", "9876543210");
//            Patient p2 = new Patient(null, "Priya Singh", 34, "Female", "priya@example.com", "9123456780");
//            patientRepo.save(p1); patientRepo.save(p2);
//
//            Doctor d1 = new Doctor(null, "Dr. Anil Mehta", "Cardiology", "anil@example.com", "7012345678");
//            Doctor d2 = new Doctor(null, "Dr. Sangeeta Rao", "Orthopedics", "sangeeta@example.com", "7098765432");
//            doctorRepo.save(d1); doctorRepo.save(d2);
//
//            Appointment a1 = new Appointment(null, p1, d1, LocalDateTime.now().plusDays(1), "Scheduled");
//            Appointment a2 = new Appointment(null, p2, d2, LocalDateTime.now().plusDays(2), "Scheduled");
//            appRepo.save(a1); appRepo.save(a2);
//        };
    }

