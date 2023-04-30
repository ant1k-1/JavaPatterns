package com.example.demo.controller;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RestController
public class DoctorController {
    private final DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
    }

    @PostMapping(value = "/doctors", consumes = {"application/json"})
    public ResponseEntity<?> createDoctor(@RequestBody Doctor doctor){
        System.out.println("log: " + doctor);
        doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/doctors")
    public ResponseEntity<List<Doctor>> getDoctor(){
        List<Doctor> doctors = doctorService.getDoctors();
        if (doctors != null && !doctors.isEmpty()){
            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/doctors/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable(name = "id") Long id){
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null){
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/doctors/{id}", consumes = {"application/json"})
    public ResponseEntity<?> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor){
        doctorService.updateDoctorById(doctor, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/doctors/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctorById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/doctors/first_name/{first_name}")
    public ResponseEntity<List<Doctor>> getDoctorsByFirstName(@PathVariable String first_name){
        return new ResponseEntity<>(doctorService.getDoctorsByFirstName(first_name),
                HttpStatus.OK);
    }

    @GetMapping(value = "/doctors/second_name/{second_name}")
    public ResponseEntity<List<Doctor>> getDoctorsBySecondName(@PathVariable String second_name){
        return new ResponseEntity<>(doctorService.getDoctorsByLastName(second_name),
                HttpStatus.OK);
    }

    @GetMapping(value = "/doctors/postion/{position}")
    public ResponseEntity<List<Doctor>> getDoctorsByPosition(@PathVariable Integer position){
        return new ResponseEntity<>(doctorService.getDoctorsByPosition(position),
                HttpStatus.OK);
    }
}
