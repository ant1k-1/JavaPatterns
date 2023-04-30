package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        PatientService.class
})
public class PatientServiceTest {
    @MockBean
    private DoctorRepository doctorRepository;

    @MockBean
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void getPatientsByFirstName() {
        // given
        List<Patient> patientList = List.of(getPatient());
        String firstName = getPatient().getFirstName();
        Mockito.when(patientRepository.findAllByFirstName(firstName)).thenReturn(patientList);

        // when
        List<Patient> get = patientService.getPatientsByFirstName(firstName);

        //then
        Mockito.verify(patientRepository, Mockito.times(1)).findAllByFirstName(firstName);
        assertThat(patientList).isEqualTo(get);
    }

    private Patient getPatient() {
        Patient patient = new Patient();

        patient.setId(1L);
        patient.setFirstName("Ivan");
        patient.setLastName("Ivanov");
        patient.setDoctorId(1L);

        return patient;
    }
}
