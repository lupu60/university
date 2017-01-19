package com.gnp.ioth.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gnp.ioth.exception.PatientNotFoundException;
import com.gnp.ioth.model.Patient;
import com.gnp.ioth.repository.PatientRepository;
import com.gnp.ioth.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

  @Autowired
  PatientRepository patientRepository;

  @Override
  public List<Patient> getAllPatients() {
    return patientRepository.findAll();
  }

  @Override
  @Transactional
  public Patient create(Patient patient) throws IllegalArgumentException {
    if (patient.getName() == null)
      throw new IllegalArgumentException();
    System.out.println(patient.getName());
    patientRepository.save(patient);
    return patient;

  }

  @Override
  @Transactional(rollbackFor = PatientNotFoundException.class)
  public Patient delete(Long id) throws PatientNotFoundException {
    Patient deletePatient = patientRepository.findOne(id);
    if (deletePatient == null)
      throw new PatientNotFoundException();
    patientRepository.delete(deletePatient);
    return deletePatient;
  }

  @Override
  public Patient findById(Long id) throws PatientNotFoundException {
    Patient findPatient = patientRepository.findOne(id);
    if (findPatient == null)
      throw new PatientNotFoundException();
    return findPatient;
  }

}
