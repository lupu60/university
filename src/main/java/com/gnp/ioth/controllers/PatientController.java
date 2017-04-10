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
import com.gnp.ioth.model.Steps;
import com.gnp.ioth.service.PatientService;

@RestController
@RequestMapping("/webapi/patient")
public class PatientController {

  private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);

  @Autowired
  PatientService patientService;

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
  public List<Patient> getAllPatients() {
    return patientService.getAllPatients();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody Patient findById(@PathVariable("id") Long id)
      throws PatientNotFoundException {
    LOG.info(id.toString());
    return patientService.findById(id);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody Patient createPatient(@RequestBody Patient patient)
      throws IllegalArgumentException {
    LOG.info(patient.toString());
    return patientService.create(patient);
  }

  @RequestMapping(value = "/", method = RequestMethod.PUT, produces = "application/json")
  public @ResponseBody Patient updatePatient(@RequestBody Patient patient)
      throws PatientNotFoundException {
    LOG.info(patient.toString());
    return patientService.update(patient);
  }

  @RequestMapping(value = "/", method = RequestMethod.DELETE, produces = "application/json")
  public @ResponseBody Patient deletePatient(@RequestBody Patient patient)
      throws PatientNotFoundException {
    LOG.info(patient.toString());
    return patientService.delete(patient);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
  public @ResponseBody Patient deletePatientbyId(@PathVariable("id") Long id)
      throws PatientNotFoundException {
    LOG.info(id.toString());
    return patientService.delete(id);
  }

  @RequestMapping(value = "/traking/steps/{id}", method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody List<Steps> getPatientSteps(@PathVariable("id") Long id)
      throws PatientNotFoundException {
    return patientService.getSteps(id);
  }

  @ExceptionHandler(PatientNotFoundException.class)
  public @ResponseBody ResponseEntity<String> handleItemNotFound(
      PatientNotFoundException exception) {
    return new ResponseEntity<String>("Patient Not Found", HttpStatus.NOT_FOUND);
  }
}
