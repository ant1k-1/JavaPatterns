package com.example.demo.controller;

import com.example.demo.entity.Patient;
import com.example.demo.entity.dto.DoctorDTO;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RestController
public class PatientController {
    private final PatientService patientService;
    private final DoctorService doctorService;
    @Autowired
    public PatientController(PatientService patientService, DoctorService doctorService){
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @PostMapping(value = "/patients", consumes = {"application/json"})
    public ResponseEntity<?> createPatient(@RequestBody Patient patient){
        System.out.println("log: " + patient);
        patientService.savePatient(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/patients")
    public ResponseEntity<List<Patient>> getPatient(){
        List<Patient> patients = patientService.getPatients();
        if (patients != null && !patients.isEmpty()){
            return new ResponseEntity<>(patients, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/patients/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable(name = "id") Long id){
        Patient patient = patientService.getPatientById(id);
        if (patient != null){
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/patients/{id}", consumes = {"application/json"})
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient patient){
        patientService.updatePatientById(patient, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/patients/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        patientService.deletePatientById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/patients/{id}/doctor")
    public ResponseEntity<DoctorDTO> getDoctorByPatientID(@PathVariable Long id){
        return new ResponseEntity<>(patientService.getDoctorByPatientId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/patients/first_name/{first_name}")
    public ResponseEntity<List<Patient>> getPatientsByFirstName(@PathVariable String first_name){
        return new ResponseEntity<>(patientService.getPatientsByFirstName(first_name),
                HttpStatus.OK);
    }

    @GetMapping(value = "/patients/second_name/{last_name}")
    public ResponseEntity<List<Patient>> getPatientsBySecondName(@PathVariable String last_name){
        return new ResponseEntity<>(patientService.getPatientsByLastName(last_name),
                HttpStatus.OK);
    }

    @GetMapping(value = "/patients/doctor_id/{doctor_id}")
    public ResponseEntity<List<Patient>> getPatientsByDoctorId(@PathVariable Long doctor_id){
        return new ResponseEntity<>(patientService.getPatientsByDoctorId(doctor_id),
                HttpStatus.OK);
    }

}
