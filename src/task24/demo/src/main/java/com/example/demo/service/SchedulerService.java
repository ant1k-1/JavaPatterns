package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@ManagedResource(description = "Scheduler service bean")
public class SchedulerService {
    private final String BACKUP_DIR = "src/main/resources/backup";
    private PatientService patientService;
    private DoctorService doctorService;

    @Autowired
    public SchedulerService(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @Scheduled(cron = "0 0/30 * * * *")
    @ManagedOperation(description = "Clear output, create .txt with database data")
    public void backupDataBase() throws IOException {
        File dir = ResourceUtils.getFile(BACKUP_DIR);
        try {
            for (File file : dir.listFiles()){
                if (file.isFile()) {
                    file.delete();
                    System.out.println(file.getName() + " is deleted");
                }
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        BufferedWriter doctors = new BufferedWriter(
                new FileWriter(BACKUP_DIR + "/doctors.txt")
        );
        BufferedWriter patients = new BufferedWriter(
                new FileWriter(BACKUP_DIR + "/patients.txt")
        );

        for (Doctor item : doctorService.getDoctors()){
            doctors.write(item.toString());
            doctors.write("\n");
        }
        doctors.close();

        for (Patient item : patientService.getPatients()) {
            patients.write(item.toString());
            patients.write("\n");
        }
        patients.close();
    }
}
