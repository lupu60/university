package com.gnp.ioth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gnp.ioth.exception.PatientNotFoundException;
import com.gnp.ioth.model.Patient;

@Service
public interface PatientService {
  List<Patient> getAllPatients();

  public Patient create(Patient patient) throws IllegalArgumentException;

  public Patient delete(Long id) throws PatientNotFoundException;

  Patient findById(Long id) throws PatientNotFoundException;
}
