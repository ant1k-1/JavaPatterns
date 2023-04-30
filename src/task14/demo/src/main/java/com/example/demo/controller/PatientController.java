package com.example.demo.controller;

import com.example.demo.entity.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PatientController {
    private ArrayList<Patient> patients = new ArrayList<>();
    @RequestMapping(value = "/add-patient", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> createPatient(
            @RequestParam("name") String firstName,
            @RequestParam("surname") String lastName
    ) {
        System.out.println("Adding new patient:");
        System.out.println(firstName + " " + lastName);
        Patient patient = new Patient(firstName, lastName);
        System.out.println(patient);
        if (patients.contains(patient)){
            return ResponseEntity.ok("Already exists");
        } else {
            patients.add(patient);
            return ResponseEntity.ok("Successfully added: " + patient);
        }
    }

    @GetMapping(value = "/show-patient")
    public ResponseEntity<String> showPatients(){
        String res = "";
        for (var patient: patients) {
            res += patient.toString() + '\n';
        }
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/del-patient", method = {RequestMethod.GET, RequestMethod.DELETE})
    public ResponseEntity<String> deletePatient(
            @RequestParam("name") String firstName,
            @RequestParam("surname") String lastName
    ) {
        System.out.println("Deleting patient:");
        System.out.println(firstName + " " + lastName);
        Patient patient = new Patient(firstName, lastName);
        if (patients.contains(patient)) {
            patients.remove(patient);
            return ResponseEntity.ok("Successfully deleted: " + patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
