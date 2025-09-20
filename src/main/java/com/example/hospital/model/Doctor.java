package com.example.hospital.model;

import javax.persistence.*;

@Entity
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String speciality;
    private String email;
    private String phone;
    public Doctor() {}
    public Doctor(Long id, String name, String speciality, String email, String phone){
        this.id = id; this.name = name; this.speciality = speciality; this.email = email; this.phone = phone;
    }
    // getters and setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getSpeciality(){ return speciality; }
    public void setSpeciality(String speciality){ this.speciality = speciality; }
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }
    public String getPhone(){ return phone; }
    public void setPhone(String phone){ this.phone = phone; }
}
