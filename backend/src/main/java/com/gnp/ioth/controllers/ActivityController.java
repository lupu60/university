package com.gnp.ioth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.service.ActivityService;

@RestController
@RequestMapping("/webapi/activity")
public class ActivityController {
  @Autowired
  ActivityService activityService;

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
  public List<Activity> getAllActivity() {
    return activityService.getAllActivity();
  }
}
