package com.example.demo.controller;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;
import com.example.demo.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RestController
public class PatientController {
    private final PatientService tableService;
    private final DoctorService doctorTableService;
    @Autowired
    public PatientController(PatientService tableService, DoctorService doctorTableService){
        this.tableService = tableService;
        this.doctorTableService = doctorTableService;
    }

    @PostMapping(value = "/patients", consumes = {"application/json"})
    public ResponseEntity<?> createPatient(@RequestBody Patient patient){
        System.out.println("log: " + patient);
        tableService.create(patient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/patients")
    public ResponseEntity<List<Patient>> getPatient(){
        List<Patient> patients = tableService.readAll();
        if (patients != null && !patients.isEmpty()){
            return new ResponseEntity<>(patients, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/patients/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable(name = "id") Long id){
        Patient patient = tableService.read(id);
        if (patient != null){
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/patients/{id}", consumes = {"application/json"})
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient patient){
        boolean isUpdated = tableService.update(patient, id);
        if (isUpdated){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping(value = "/patients/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        boolean isDeleted = tableService.delete(id);
        if (isDeleted){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping(value = "/patients/{id}/doctor")
    public ResponseEntity<Doctor> getDoctorByPatientID(@PathVariable Long id){
        Patient patient = tableService.read(id);
        return new ResponseEntity<>(doctorTableService.read(patient.getDoctorId()),HttpStatus.OK);
    }

    @GetMapping(value = "/patients/first_name/{first_name}")
    public ResponseEntity<List<Patient>> getPatientsByFirstName(@PathVariable String first_name){
        return new ResponseEntity<>(tableService.getPatientsFilteredBy("firstName", first_name),
                HttpStatus.OK);
    }

    @GetMapping(value = "/patients/second_name/{last_name}")
    public ResponseEntity<List<Patient>> getPatientsBySecondName(@PathVariable String last_name){
        return new ResponseEntity<>(tableService.getPatientsFilteredBy("lastName", last_name),
                HttpStatus.OK);
    }

    @GetMapping(value = "/patients/doctor_id/{doctor_id}")
    public ResponseEntity<List<Patient>> getPatientsByDoctorId(@PathVariable String doctor_id){
        return new ResponseEntity<>(tableService.getPatientsFilteredBy("doctorId", doctor_id),
                HttpStatus.OK);
    }

}
