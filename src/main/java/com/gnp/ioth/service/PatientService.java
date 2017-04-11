package com.gnp.ioth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gnp.ioth.exception.PatientNotFoundException;
import com.gnp.ioth.model.Patient;

@Service
public interface PatientService {

  public Patient create(Patient patient) throws IllegalArgumentException;

  public List<Patient> getAllPatients();

  public Patient findById(Long id) throws PatientNotFoundException;

  public Patient update(Patient patient) throws PatientNotFoundException;

  public Patient delete(Long id) throws PatientNotFoundException;

  public Patient delete(Patient patient) throws PatientNotFoundException;

}
