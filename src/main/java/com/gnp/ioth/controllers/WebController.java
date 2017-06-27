package com.gnp.ioth.controllers;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.Patient;
import com.gnp.ioth.model.SmartBand;
import com.gnp.ioth.service.ActivityService;
import com.gnp.ioth.service.PatientService;
import com.gnp.ioth.service.SmartBandService;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi")
public class WebController {

  private static final Logger LOG = LoggerFactory.getLogger(WebController.class);
  @Autowired
  SmartBandService smartBandService;
  @Autowired
  PatientService patientService;
  @Autowired
  ActivityService activityService;

  @RequestMapping(method = RequestMethod.GET)
  public String hello() {
    LOG.info("/");
    return "<strong>Welcome to IoT Healthcare</strong>";
  }

  @RequestMapping(value = "/mock", method = RequestMethod.GET)
  public String mock() {
    java.util.Date date = new java.util.Date();
    Long currentDayStart = date.getTime() - date.getTime() % 86400000;
    long offset = currentDayStart;
    long end = date.getTime();

    // long offset = Timestamp.valueOf("2017-01-01 00:00:00").getTime();
    // long end = Timestamp.valueOf("2017-04-20 00:00:00").getTime();

    long diff = end - offset + 1;

    SmartBand s1 = new SmartBand("C8:0F:10:88:2A:5B");
    SmartBand s2 = new SmartBand("C8:0F:10:99:2B:1B");
    SmartBand s3 = new SmartBand("BE:22:5C:AA:22:11");
    SmartBand s4 = new SmartBand("C8:0F:10:33:A8:3C");
    SmartBand s5 = new SmartBand("17:5C:91:0B:38:59");

    for (int i = 0; i < 10; i++) {
      ArrayList<Integer> hr = new ArrayList<>();
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      activityService
          .record(new Activity(new Random().nextLong(), new Random().nextInt(10000 - 100) + 100, hr,
              s1, new Timestamp(offset + (long) (Math.random() * diff))));
      activityService
          .record(new Activity(new Random().nextLong(), new Random().nextInt(10000 - 100) + 100, hr,
              s2, new Timestamp(offset + (long) (Math.random() * diff))));
      activityService
          .record(new Activity(new Random().nextLong(), new Random().nextInt(10000 - 100) + 100, hr,
              s3, new Timestamp(offset + (long) (Math.random() * diff))));
      activityService
          .record(new Activity(new Random().nextLong(), new Random().nextInt(10000 - 100) + 100, hr,
              s4, new Timestamp(offset + (long) (Math.random() * diff))));
      activityService
          .record(new Activity(new Random().nextLong(), new Random().nextInt(10000 - 100) + 100, hr,
              s5, new Timestamp(offset + (long) (Math.random() * diff))));
    }

    LOG.info("/mock");

    return "mockdone";
  }
  @RequestMapping(value = "/mockMonth", method = RequestMethod.GET)
  public String mockToday() {
//    java.util.Date date = new java.util.Date();
//    Long currentDayStart = date.getTime() - date.getTime() % 86400000;
//    long offset = currentDayStart;
//    long end = date.getTime();

     long offset = Timestamp.valueOf("2017-06-01 00:00:00").getTime();
     long end = Timestamp.valueOf("2017-06-28 00:00:00").getTime();

    long diff = end - offset + 1;

    SmartBand s1 = new SmartBand("C8:0F:10:88:2A:5B");
    SmartBand s2 = new SmartBand("C8:0F:10:99:2B:1B");
    SmartBand s3 = new SmartBand("BE:22:5C:AA:22:11");
    SmartBand s4 = new SmartBand("C8:0F:10:33:A8:3C");
    SmartBand s5 = new SmartBand("17:5C:91:0B:38:59");

    for (int i = 0; i < 100; i++) {
      ArrayList<Integer> hr = new ArrayList<>();
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      hr.add(new Random().nextInt(150 - 78) + 78);
      activityService
          .record(new Activity(new Random().nextLong(), new Random().nextInt(10000 - 100) + 100, hr,
              s1, new Timestamp(offset + (long) (Math.random() * diff))));
      activityService
          .record(new Activity(new Random().nextLong(), new Random().nextInt(10000 - 100) + 100, hr,
              s2, new Timestamp(offset + (long) (Math.random() * diff))));
      activityService
          .record(new Activity(new Random().nextLong(), new Random().nextInt(10000 - 100) + 100, hr,
              s3, new Timestamp(offset + (long) (Math.random() * diff))));
      activityService
          .record(new Activity(new Random().nextLong(), new Random().nextInt(10000 - 100) + 100, hr,
              s4, new Timestamp(offset + (long) (Math.random() * diff))));
      activityService
          .record(new Activity(new Random().nextLong(), new Random().nextInt(10000 - 100) + 100, hr,
              s5, new Timestamp(offset + (long) (Math.random() * diff))));
    }

    LOG.info("/mock");

    return "mockdone";
  }
  @RequestMapping(value = "/initialmock", method = RequestMethod.GET)
  public String mock2() {
    SmartBand s1 = new SmartBand("C8:0F:10:88:2A:5B");
    SmartBand s2 = new SmartBand("C8:0F:10:99:2B:1B");
    SmartBand s3 = new SmartBand("BE:22:5C:AA:22:11");
    SmartBand s4 = new SmartBand("C8:0F:10:33:A8:3C");
    SmartBand s5 = new SmartBand("17:5C:91:0B:38:59");

    smartBandService.create(s1);
    smartBandService.create(s2);
    smartBandService.create(s3);
    smartBandService.create(s4);
    smartBandService.create(s5);

    Patient p1 = new Patient(new Random().nextLong(), "Bogdan", true, 22, 180, 80, s1);
    Patient p2 = new Patient(new Random().nextLong(), "Jany", false, 30, 100, 280, s2);
    Patient p3 = new Patient(new Random().nextLong(), "Alexandra", true, 22, 180, 80, s3);
    Patient p4 = new Patient(new Random().nextLong(), "Sorin", false, 30, 100, 280, s4);
    Patient p5 = new Patient(new Random().nextLong(), "Oliver", false, 30, 100, 280, s5);

    patientService.create(p1);
    patientService.create(p2);
    patientService.create(p3);
    patientService.create(p4);
    patientService.create(p5);
    LOG.info("/mock");
    return "mockdone";
  }
}
