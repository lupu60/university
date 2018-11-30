package com.gnp.ioth.repository;

import com.gnp.ioth.model.Patient;
import com.gnp.ioth.model.SmartBand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

  Patient findBySmartBand(SmartBand smartBand);
}
