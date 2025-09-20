package com.example.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.model.Patient;
import com.example.hospital.model.Doctor;
import com.example.hospital.model.Appointment;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

    private final PatientRepository patientRepo;
    private final DoctorRepository doctorRepo;
    private final AppointmentRepository appRepo;

    public WebController(PatientRepository patientRepo, DoctorRepository doctorRepo, AppointmentRepository appRepo){
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
        this.appRepo = appRepo;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("patients", patientRepo.findAll());
        model.addAttribute("doctors", doctorRepo.findAll());
        model.addAttribute("appointments", appRepo.findAll());
        return "index";
    }

    // Patients
    @GetMapping("/patients")
    public String patients(Model model){
        model.addAttribute("patients", patientRepo.findAll());
        model.addAttribute("patient", new Patient());
        return "patients";
    }
    @PostMapping("/patients")
    public String addPatient(@ModelAttribute Patient patient){
        patientRepo.save(patient);
        return "redirect:/patients";
    }

    // Doctors
    @GetMapping("/doctors")
    public String doctors(Model model){
        model.addAttribute("doctors", doctorRepo.findAll());
        model.addAttribute("doctor", new Doctor());
        return "doctors";
    }
    @PostMapping("/doctors")
    public String addDoctor(@ModelAttribute Doctor doctor){
        doctorRepo.save(doctor);
        return "redirect:/doctors";
    }

    // Appointments
    @GetMapping("/appointments")
    public String appointments(Model model){
        model.addAttribute("appointments", appRepo.findAll());
        model.addAttribute("patients", patientRepo.findAll());
        model.addAttribute("doctors", doctorRepo.findAll());
        model.addAttribute("appointment", new Appointment());
        return "appointments";
    }
    @PostMapping("/appointments")
    public String bookAppointment(@RequestParam Long patientId, @RequestParam Long doctorId, @RequestParam String datetime){
        Optional<Patient> p = patientRepo.findById(patientId);
        Optional<Doctor> d = doctorRepo.findById(doctorId);
        if(p.isPresent() && d.isPresent()){
            Appointment a = new Appointment();
            a.setPatient(p.get());
            a.setDoctor(d.get());
            a.setAppointmentTime(LocalDateTime.parse(datetime));
            a.setStatus("Scheduled");
            appRepo.save(a);
        }
        return "redirect:/appointments";
    }

    @PostMapping("/appointments/{id}/cancel")
    public String cancelAppointment(@PathVariable Long id){
        Optional<Appointment> a = appRepo.findById(id);
        if(a.isPresent()){
            Appointment ap = a.get();
            ap.setStatus("Cancelled");
            appRepo.save(ap);
        }
        return "redirect:/appointments";
    }
}
