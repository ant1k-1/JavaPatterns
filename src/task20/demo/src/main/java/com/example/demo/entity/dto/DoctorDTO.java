package com.example.demo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class DoctorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer position;
    private List<PatientDTO> patients;
}
