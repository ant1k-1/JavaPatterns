package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorService {
    @Autowired
    private final DoctorRepository doctorRepository;

    public List<Doctor> getDoctors() {
        log.info("Get all doctors");
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        log.info("Get doctor by id {}", id);
        return doctorRepository.getReferenceById(id);
    }

    public void saveDoctor(Doctor doctor){
        log.info("Save doctor {}", doctor);
        doctorRepository.save(doctor);
    }

    public void deleteDoctorById(Long id){
        log.info("Delete doctor by id {}", id);
        doctorRepository.deleteById(id);
    }

    public void updateDoctorById(Doctor doctor, Long id){
        log.info("Update doctor {} by id {}", doctor, id);
        doctor.setId(id);
        doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctorsByFirstName(String firstName) {
        log.info("Get doctors by firstname - {}", firstName);
        return doctorRepository.findAllByFirstName(firstName);
    }

    public List<Doctor> getDoctorsByLastName(String lastName) {
        log.info("Get doctors by lastname - {}", lastName);
        return doctorRepository.findAllByLastName(lastName);
    }

    public List<Doctor> getDoctorsByPosition(Integer position) {
        log.info("Get doctors by position {}", position);
        return doctorRepository.findAllByPosition(position);
    }
}
