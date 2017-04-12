package com.gnp.ioth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gnp.ioth.model.Patient;
import com.gnp.ioth.model.SmartBand;

import javassist.NotFoundException;

@Service
public interface PatientService {

  public Patient create(Patient patient) throws IllegalArgumentException;

  public List<Patient> getAllPatients();

  public Patient findById(Long id) throws NotFoundException;

  public Patient findBySmartBand(SmartBand smartBand) throws NotFoundException;

  public Patient update(Patient patient) throws NotFoundException;

  public Patient delete(Long id) throws NotFoundException;

  public Patient delete(Patient patient) throws NotFoundException;

}
