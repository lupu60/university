package com.gnp.ioth.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.Patient;
import com.gnp.ioth.model.SmartBand;
import com.gnp.ioth.service.ActivityService;
import com.gnp.ioth.service.PatientService;

import javassist.NotFoundException;


@RestController
@RequestMapping("/gateway")
public class GatewayController {

  private static final Logger LOG = LoggerFactory.getLogger(GatewayController.class);

  @Autowired
  ActivityService activityService;

  @Autowired
  PatientService patientService;

  @RequestMapping(value = "/activity", method = RequestMethod.PUT, produces = "application/json")
  public String recordActivity(@RequestBody Activity activity) {
    activityService.record(activity);
    return "recorded";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody Patient getPatient(@PathVariable("id") String mac) throws NotFoundException {
    LOG.info(mac);
    return patientService.findBySmartBand(new SmartBand(mac));
  }

}
