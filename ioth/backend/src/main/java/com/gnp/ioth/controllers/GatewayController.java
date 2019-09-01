package com.gnp.ioth.controllers;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.DeviceInfo;
import com.gnp.ioth.model.Patient;
import com.gnp.ioth.model.SmartBand;
import com.gnp.ioth.service.ActivityService;
import com.gnp.ioth.service.DeviceInfoService;
import com.gnp.ioth.service.PatientService;
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
@RequestMapping("/gateway")
public class GatewayController {

  private static final Logger LOG = LoggerFactory.getLogger(GatewayController.class);

  @Autowired
  ActivityService activityService;

  @Autowired
  PatientService patientService;

  @Autowired
  DeviceInfoService deviceInfoService;

  @RequestMapping(value = "/activity", method = RequestMethod.PUT, produces = "application/json")
  public Activity recordActivity(@RequestBody Activity activity) {
    return activityService.record(activity);
  }

  @RequestMapping(value = "/deviceinfo", method = RequestMethod.PUT, produces = "application/json")
  public DeviceInfo recordDeviceInfo(@RequestBody DeviceInfo deviceInfo) {
    return deviceInfoService.recordDeviceInfo(deviceInfo);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public Patient getPatient(@PathVariable("id") String mac) throws NotFoundException {
    LOG.info(mac);
    return patientService.findBySmartBand(new SmartBand(mac));
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseBody
  public ResponseEntity<String> handleItemNotFound(NotFoundException exception) {
    return new ResponseEntity<String>("Band Not Found", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseBody
  public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exception) {
    return new ResponseEntity<String>("IllegalArgumentException", HttpStatus.NOT_FOUND);
  }
}
