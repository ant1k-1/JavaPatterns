package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        SchedulerService.class
})
public class SchedulerServiceTest {
    @MockBean
    private DoctorService doctorService;

    @MockBean
    private PatientService patientService;

    @Autowired
    private SchedulerService schedulerService;

    @Test
    public void backupDataBase() throws IOException {
        // given
        List<Doctor> doctorList = List.of(getDoctor());
        Mockito.when(doctorService.getDoctors()).thenReturn(doctorList);

        List<Patient> patientList = List.of(getPatient());
        Mockito.when(patientService.getPatients()).thenReturn(patientList);

        // when
        schedulerService.backupDataBase();

        // then
        Mockito.verify(doctorService, Mockito.times(1)).getDoctors();
        Mockito.verify(patientService, Mockito.times(1)).getPatients();
    }



    private Doctor getDoctor(){
        Doctor doctor = new Doctor();
        doctor.setId(1L);
        doctor.setFirstName("Ivan");
        doctor.setLastName("Ivanov");
        doctor.setPosition(1);

        return doctor;
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
