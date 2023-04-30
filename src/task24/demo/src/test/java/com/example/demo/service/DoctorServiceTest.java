package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
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
        DoctorService.class
})
public class DoctorServiceTest {
    @MockBean
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;

    @Test
    public void getDoctorsByFirstName(){
        // given
        List<Doctor> doctorList = List.of(getDoctor());
        String firstName = getDoctor().getFirstName();
        Mockito.when(doctorRepository.findAllByFirstName(firstName)).thenReturn(doctorList);

        // when
        List<Doctor> get = doctorService.getDoctorsByFirstName(firstName);

        //then
        Mockito.verify(doctorRepository, Mockito.times(1)).findAllByFirstName(firstName);
        assertThat(doctorList).isEqualTo(get);
    }

    private Doctor getDoctor(){
        Doctor doctor = new Doctor();
        doctor.setId(1L);
        doctor.setFirstName("Ivan");
        doctor.setLastName("Ivanov");
        doctor.setPosition(1);

        return doctor;
    }
}
