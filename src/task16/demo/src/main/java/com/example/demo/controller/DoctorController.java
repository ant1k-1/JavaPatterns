package com.example.demo.controller;

import com.example.demo.entity.Doctor;
import com.example.demo.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    private final TableService<Doctor> tableService;
    @Autowired
    public DoctorController(TableService<Doctor> tableService){
        this.tableService = tableService;
    }

    @PostMapping(value = "/doctors", consumes = {"application/json"})
    public ResponseEntity<?> createDoctor(@RequestBody Doctor doctor){
        System.out.println("log: " + doctor);
        tableService.create(doctor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/doctors")
    public ResponseEntity<List<Doctor>> getDoctor(){
        List<Doctor> doctors = tableService.readAll();
        if (doctors != null && !doctors.isEmpty()){
            return new ResponseEntity<>(doctors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/doctors/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable(name = "id") Long id){
        Doctor doctor = tableService.read(id);
        if (doctor != null){
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/doctors/{id}", consumes = {"application/json"})
    public ResponseEntity<?> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor){
        boolean isUpdated = tableService.update(doctor, id);
        if (isUpdated){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping(value = "/doctors/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id){
        boolean isDeleted = tableService.delete(id);
        if (isDeleted){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
