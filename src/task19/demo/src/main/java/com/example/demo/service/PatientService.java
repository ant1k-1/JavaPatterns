package com.example.demo.service;

import com.example.demo.entity.Patient;
import com.example.demo.entity.dto.DoctorDTO;
import com.example.demo.entity.dto.PatientDTO;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientService {
    @Autowired
    private final PatientRepository patientRepository;

    @Autowired
    private final DoctorRepository doctorRepository;

    public List<Patient> getPatients() {
        log.info("Get all patients");
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        log.info("Get patient by id {}", id);
        return patientRepository.getReferenceById(id);
    }

    public void savePatient(Patient patient) {
        log.info("Save patient {}", patient);
        patientRepository.save(patient);
    }

    public void deletePatientById(Long id) {
        log.info("Delete patient by id {}", id);
        patientRepository.deleteById(id);
    }

    public void updatePatientById(Patient patient, Long id) {
        log.info("Update patient {} by id {}", patient, id);
        patient.setId(id);
        patientRepository.save(patient);
    }

    public DoctorDTO getDoctorByPatientId(Long patientId) {
        log.info("Get doctor by patient id {}", patientId);
        PatientDTO patientDTO = patientRepository.getById(patientId).makeDTO();
        DoctorDTO doctorDTO = doctorRepository.getById(patientDTO.getDoctorId()).makeDTO();
        return doctorDTO;
    }

    public List<Patient> getPatientsByFirstName(String firstName){
        log.info("Get patients by firstname - {}", firstName);
        return patientRepository.findAllByFirstName(firstName);
    }

    public List<Patient> getPatientsByLastName(String lastName) {
        log.info("Get patients by lastname - {}", lastName);
        return patientRepository.findAllByLastName(lastName);
    }

    public List<Patient> getPatientsByDoctorId(Long doctorId) {
        log.info("Get patients by doctor_id {}", doctorId);
        return patientRepository.findAllByDoctorId(doctorId);
    }
}
