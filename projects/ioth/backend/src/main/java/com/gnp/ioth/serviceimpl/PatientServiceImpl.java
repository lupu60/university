package com.gnp.ioth.serviceimpl;

import com.gnp.ioth.model.Patient;
import com.gnp.ioth.model.SmartBand;
import com.gnp.ioth.repository.PatientRepository;
import com.gnp.ioth.repository.SmartBandRepository;
import com.gnp.ioth.service.PatientService;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientServiceImpl implements PatientService {

  private static final String PATIENT_NOT_FOUND = "Patient Not Found";

  @Autowired
  PatientRepository patientRepository;

  @Autowired
  SmartBandRepository smartBandRepository;

  @Override
  public List<Patient> getAllPatients() {
    return patientRepository.findAll(new Sort(Sort.Direction.ASC, "Id"));
  }

  @Override
  @Transactional
  public Patient create(Patient patient) throws IllegalArgumentException {
    if (patient.getName() == null) {
      throw new IllegalArgumentException();
    }
    patientRepository.save(patient);
    return patient;

  }

  @Override
  public Patient findById(Long id) throws NotFoundException {
    Patient returnPatient = patientRepository.findOne(id);
    if (returnPatient == null) {
      throw new NotFoundException(PATIENT_NOT_FOUND);
    }
    return returnPatient;
  }

  @Override
  public Patient update(Patient patient) throws NotFoundException {
    Patient updatePatient = patientRepository.findOne(patient.getId());
    if (updatePatient == null) {
      throw new NotFoundException(PATIENT_NOT_FOUND);
    }
    return patientRepository.save(patient);
  }

  @Override
  @Transactional(rollbackFor = NotFoundException.class)
  public Patient delete(Long id) throws NotFoundException {
    Patient deletePatient = patientRepository.findOne(id);
    if (deletePatient == null) {
      throw new NotFoundException(PATIENT_NOT_FOUND);
    }
    patientRepository.delete(deletePatient);
    return deletePatient;
  }

  @Override
  @Transactional(rollbackFor = NotFoundException.class)
  public Patient delete(Patient patient) throws NotFoundException {
    patientRepository.delete(patient);
    return patient;
  }

  @Override
  public Patient findBySmartBand(SmartBand smartBand) throws NotFoundException {
    if (!smartBandRepository.exists(smartBand.getMac())) {
      throw new NotFoundException(smartBand.getMac() + " not found");
    }
    return patientRepository.findBySmartBand(smartBand);
  }

}