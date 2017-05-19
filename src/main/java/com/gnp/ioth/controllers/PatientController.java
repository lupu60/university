package com.gnp.ioth.controllers;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.Patient;
import com.gnp.ioth.service.ActivityService;
import com.gnp.ioth.service.PatientService;
import java.util.List;
import javassist.NotFoundException;
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

@RestController
@RequestMapping("/webapi/patient")
public class PatientController {

  private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);

  @Autowired
  PatientService patientService;

  @Autowired
  ActivityService activityService;

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
  public List<Patient> getAllPatients() {
    return patientService.getAllPatients();
  }

  @RequestMapping(value = "/activity/{mac}", method = RequestMethod.GET,
    produces = "application/json")
  public List<Activity> getTodayActivity(@PathVariable("mac") String mac) {
    return activityService.getTodayActivity(mac);
  }

  @RequestMapping(value = "/activity/{mac}/{timestamp}", method = RequestMethod.GET,
    produces = "application/json")
  public List<Activity> getDateActivity(@PathVariable("mac") String mac,
    @PathVariable("timestamp") long timestamp) {
    return activityService.getDateActivity(mac, timestamp);
  }

  @RequestMapping(value = "/highestactivity/{mac}", method = RequestMethod.GET,
    produces = "application/json")
  public List<Activity> getHighestActivity(@PathVariable("mac") String mac) {
    return activityService.getHighestActivity(mac);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody
  Patient findById(@PathVariable("id") Long id) throws NotFoundException {
    LOG.info(id.toString());
    return patientService.findById(id);
  }

  @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody
  Patient createPatient(@RequestBody Patient patient)
    throws IllegalArgumentException {
    LOG.info(patient.toString());
    return patientService.create(patient);
  }

  @RequestMapping(value = "/", method = RequestMethod.PUT, produces = "application/json")
  public @ResponseBody
  Patient updatePatient(@RequestBody Patient patient)
    throws NotFoundException {
    LOG.info(patient.toString());
    return patientService.update(patient);
  }

  @RequestMapping(value = "/", method = RequestMethod.DELETE, produces = "application/json")
  public @ResponseBody
  Patient deletePatient(@RequestBody Patient patient)
    throws NotFoundException {
    LOG.info(patient.toString());
    return patientService.delete(patient);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
  public @ResponseBody
  Patient deletePatientbyId(@PathVariable("id") Long id)
    throws NotFoundException {
    LOG.info(id.toString());
    return patientService.delete(id);
  }

  @ExceptionHandler(NotFoundException.class)
  public @ResponseBody
  ResponseEntity<String> handleItemNotFound(NotFoundException exception) {
    return new ResponseEntity<String>("Patient Not Found", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public @ResponseBody
  ResponseEntity<String> handleIllegalArgumentException(
    IllegalArgumentException exception) {
    return new ResponseEntity<String>("IllegalArgumentException", HttpStatus.NOT_FOUND);
  }
}
