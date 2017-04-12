package com.gnp.ioth.controllers;

import java.sql.Timestamp;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.Patient;
import com.gnp.ioth.model.SmartBand;
import com.gnp.ioth.service.ActivityService;
import com.gnp.ioth.service.PatientService;
import com.gnp.ioth.service.SmartBandService;

@RestController
@RequestMapping("/webapi")
public class WebController {
  @Autowired
  SmartBandService smartBandService;

  @Autowired
  PatientService patientService;

  @Autowired
  ActivityService activityService;
  // @SuppressWarnings("unused")
  // private LeshanServerWrapper leshanServerWrapper = new LeshanServerWrapper();
  private static final Logger LOG = LoggerFactory.getLogger(WebController.class);

  @RequestMapping(method = RequestMethod.GET)
  public String hello() {
    LOG.info("/");
    return "Welcome to IoT Healthcare";
  }

  @RequestMapping(value = "/mock", method = RequestMethod.GET)
  public String mock() {
    long offset = Timestamp.valueOf("2012-01-01 00:00:00").getTime();
    long end = Timestamp.valueOf("2013-01-01 00:00:00").getTime();
    long diff = end - offset + 1;

    SmartBand s1 = new SmartBand("C8:0F:10:88:2A:5B");
    SmartBand s2 = new SmartBand("C8:0F:10:99:2B:1B");

    smartBandService.create(s1);
    smartBandService.create(s2);
    Patient p1 = new Patient(new Random().nextLong(), "name", true, 22, 180, 80, s1);
    Patient p2 = new Patient(new Random().nextLong(), "name2", false, 30, 100, 280, s2);

    patientService.create(p1);
    patientService.create(p2);

    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    activityService.record(new Activity(new Random().nextLong(),
        new Random().nextInt(), new int[] {new Random().nextInt(100), new Random().nextInt(100),
            new Random().nextInt(100), new Random().nextInt(100)},
        s1, new Timestamp(offset + (long) (Math.random() * diff))));
    LOG.info("/mock");
     
    return "mockdone";
  }
}
