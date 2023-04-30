package com.example.demo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Long doctorId;
}
