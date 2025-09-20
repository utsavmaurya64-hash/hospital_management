package com.example.hospital.model;

import javax.persistence.*;

@Entity
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String phone;
    public Patient() {}
    public Patient(Long id, String name, Integer age, String gender, String email, String phone){
        this.id = id; this.name = name; this.age = age; this.gender = gender; this.email = email; this.phone = phone;
    }
    // getters and setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public Integer getAge(){ return age; }
    public void setAge(Integer age){ this.age = age; }
    public String getGender(){ return gender; }
    public void setGender(String gender){ this.gender = gender; }
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }
    public String getPhone(){ return phone; }
    public void setPhone(String phone){ this.phone = phone; }
}
