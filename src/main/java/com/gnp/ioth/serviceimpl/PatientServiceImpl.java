package com.gnp.ioth.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    return patientRepository.findAll(new Sort(Sort.Direction.ASC, "Id"));
  }

  @Override
  @Transactional
  public Patient create(Patient patient) throws IllegalArgumentException {
    if (patient.getName() == null)
      throw new IllegalArgumentException();
    patientRepository.save(patient);
    return patient;

  }

  @Override
  public Patient findById(Long id) throws PatientNotFoundException {
    Patient returnPatient = patientRepository.findOne(id);
    if (returnPatient == null)
      throw new PatientNotFoundException();
    return returnPatient;
  }

  @Override
  public Patient update(Patient patient) throws PatientNotFoundException {
    Patient updatePatient = patientRepository.findOne(patient.getId());
    if (updatePatient == null)
      throw new PatientNotFoundException();
    return patientRepository.save(patient);
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
  @Transactional(rollbackFor = PatientNotFoundException.class)
  public Patient delete(Patient patient) throws PatientNotFoundException {
    patientRepository.delete(patient);
    return patient;
  }

}
