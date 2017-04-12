package com.gnp.ioth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gnp.ioth.model.Patient;
import com.gnp.ioth.model.SmartBand;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
  public Patient findBySmartBand(SmartBand smartBand);
}
