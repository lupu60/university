package com.gnp.ioth.service;

import com.gnp.ioth.model.Patient;
import com.gnp.ioth.model.SmartBand;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface PatientService {

  Patient create(Patient patient) throws IllegalArgumentException;

  List<Patient> getAllPatients();

  Patient findById(Long id) throws NotFoundException;

  Patient findBySmartBand(SmartBand smartBand) throws NotFoundException;

  Patient update(Patient patient) throws NotFoundException;

  Patient delete(Long id) throws NotFoundException;

  Patient delete(Patient patient) throws NotFoundException;

}
