package com.example.demo.controller;

import com.example.demo.entity.Doctor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DoctorController {
    private ArrayList<Doctor> doctors = new ArrayList<>();
    @RequestMapping(value = "/add-doctor", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResponseEntity<String> createDoctor(
            @RequestParam("name") String firstName,
            @RequestParam("surname") String lastName,
            @RequestParam("pos") Integer position
    ) {
        System.out.println("Adding new doctor:");
        System.out.println(firstName + " " + lastName + " " + position);
        Doctor doctor = new Doctor(firstName, lastName, position);
        System.out.println(doctor);
        if (doctors.contains(doctor)){
            return ResponseEntity.ok("Already exists");
        } else {
            doctors.add(doctor);
            return ResponseEntity.ok("Successfully added: " + doctor);
        }
    }

    @GetMapping(value = "/show-doctor")
    public ResponseEntity<String> showDoctors(){
        String res = "";
        for (var doctor: doctors) {
            res += doctor.toString() + '\n';
        }
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/del-doctor", method = {RequestMethod.GET, RequestMethod.DELETE})
    public ResponseEntity<String> deleteDoctor(
            @RequestParam("name") String firstName,
            @RequestParam("surname") String lastName,
            @RequestParam("pos") Integer position
    ) {
        System.out.println("Deleting doctor:");
        System.out.println(firstName + " " + lastName + " " + position);
        Doctor doctor = new Doctor(firstName, lastName, position);
        if (doctors.contains(doctor)) {
            doctors.remove(doctor);
            return ResponseEntity.ok("Successfully deleted: " + doctor);
        } else {
            return ResponseEntity.ok("Not found: " + doctor);
        }
    }
}
