package com.example.demo.service;

import com.example.demo.entity.Patient;
import com.example.demo.entity.dto.DoctorDTO;
import com.example.demo.entity.dto.PatientDTO;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    @Autowired
    private final PatientRepository patientRepository;

    @Autowired
    private final DoctorRepository doctorRepository;

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.getReferenceById(id);
    }

    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    public void updatePatientById(Patient patient, Long id) {
        patient.setId(id);
        patientRepository.save(patient);
    }

    public DoctorDTO getDoctorByPatientId(Long patientId) {
        PatientDTO patientDTO = patientRepository.getById(patientId).makeDTO();
        DoctorDTO doctorDTO = doctorRepository.getById(patientDTO.getDoctorId()).makeDTO();
        return doctorDTO;
    }

    public List<Patient> getPatientsByFirstName(String firstName){
        return patientRepository.findAllByFirstName(firstName);
    }

    public List<Patient> getPatientsByLastName(String lastName) {
        return patientRepository.findAllByLastName(lastName);
    }

    public List<Patient> getPatientsByDoctorId(Long doctorId) {
        return patientRepository.findAllByDoctorId(doctorId);
    }
}
