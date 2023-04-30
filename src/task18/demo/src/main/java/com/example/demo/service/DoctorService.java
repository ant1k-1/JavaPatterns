package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    @Autowired
    private final DoctorRepository doctorRepository;

    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.getReferenceById(id);
    }

    public void saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public void deleteDoctorById(Long id){
        doctorRepository.deleteById(id);
    }

    public void updateDoctorById(Doctor doctor, Long id){
        doctor.setId(id);
        doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctorsByFirstName(String firstName) {
        return doctorRepository.findAllByFirstName(firstName);
    }

    public List<Doctor> getDoctorsByLastName(String lastName) {
        return doctorRepository.findAllByLastName(lastName);
    }

    public List<Doctor> getDoctorsByPosition(Integer position) {
        return doctorRepository.findAllByPosition(position);
    }
}
