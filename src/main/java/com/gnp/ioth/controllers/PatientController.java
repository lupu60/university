package com.gnp.ioth.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnp.ioth.exception.PatientNotFoundException;
import com.gnp.ioth.model.Patient;
import com.gnp.ioth.service.PatientService;

@RestController
@RequestMapping("/webapi/patient")
public class PatientController {
  private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);
  @Autowired
  PatientService patientService;

  @RequestMapping(value = "/", produces = "application/json")
  public List<Patient> getAllPatients() {
    return patientService.getAllPatients();
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody Patient createPatient(@RequestBody Patient patient) {
    LOG.info(patient.toString());
    return patientService.create(patient);
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST,
      produces = "application/json")
  public @ResponseBody Patient deletePatient(@PathVariable("id") Long id)
      throws PatientNotFoundException {
    LOG.info(id.toString());
    return patientService.delete(id);
  }

  @ExceptionHandler(PatientNotFoundException.class)
  public @ResponseBody ResponseEntity<String> handleItemNotFound(
      PatientNotFoundException exception) {
    return new ResponseEntity<String>("Patient Not Found", HttpStatus.NOT_FOUND);
  }
}
