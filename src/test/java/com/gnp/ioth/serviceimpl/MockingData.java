package com.gnp.ioth.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.gnp.ioth.model.Patient;
import com.gnp.ioth.model.Patient.Sex;
import com.gnp.ioth.service.PatientService;

public class MockingData {

  @Autowired
  PatientService patientService;

  public void createPatient() {
    patientService.create(new Patient("Adam Potts", Sex.MALE, UUID.randomUUID()));
    patientService.create(new Patient("Amira Keller", Sex.MALE, UUID.randomUUID()));
    patientService.create(new Patient("Damaris Sandoval", Sex.MALE, UUID.randomUUID()));
    patientService.create(new Patient("Broderick Beard", Sex.MALE, UUID.randomUUID()));
    patientService.create(new Patient("Orion Novak", Sex.MALE, UUID.randomUUID()));
    patientService.create(new Patient("Ezequiel Osborn", Sex.FEMALE, UUID.randomUUID()));
    patientService.create(new Patient("Trystan Huynh", Sex.FEMALE, UUID.randomUUID()));
  }

  public void getAllPatient() {
    System.out.println(patientService.getAllPatients());
  }
}
