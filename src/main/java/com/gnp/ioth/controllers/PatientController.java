package com.gnp.ioth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnp.ioth.model.Patient;
import com.gnp.ioth.service.PatientService;

@RestController
@RequestMapping("/webapi/patient")
public class PatientController {
  @Autowired
  PatientService patientService;

  @RequestMapping(value = "/createPatient", method = RequestMethod.POST)
  public @ResponseBody Patient createPatient(@RequestBody Patient patient) {
    return patientService.create(patient);
  }

}
