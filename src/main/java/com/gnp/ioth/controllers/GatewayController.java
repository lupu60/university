package com.gnp.ioth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.service.ActivityService;


@RestController
@RequestMapping("/gateway")
public class GatewayController {
  @Autowired
  ActivityService activityService;
  
  @RequestMapping(value = "/activity", method = RequestMethod.PUT, produces = "application/json")
  public String getAllActivity(@RequestBody Activity activity) {
    activityService.record(activity);
    return "recorted";
  }

}
