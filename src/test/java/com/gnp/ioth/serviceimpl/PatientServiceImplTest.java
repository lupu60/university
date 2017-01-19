package com.gnp.ioth.serviceimpl;

import java.sql.Date;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gnp.ioth.model.Patient;
import com.gnp.ioth.model.Patient.Sex;
import com.gnp.ioth.service.PatientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceImplTest {
  @Autowired
  PatientService patientService;

  @Test
  public void createPatient() {
    // Arange
    Patient patient = new Patient((long) 5435, "patient1", Sex.MALE,
        new Date(Math.abs(System.currentTimeMillis() - new Random().nextLong())),
        UUID.randomUUID());
    // Act
    patientService.create(patient);
  }
}
