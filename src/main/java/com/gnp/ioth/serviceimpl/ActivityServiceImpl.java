package com.gnp.ioth.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.SmartBand;
import com.gnp.ioth.repository.ActivityRepository;
import com.gnp.ioth.repository.SmartBandRepository;
import com.gnp.ioth.service.ActivityService;


@Service
public class ActivityServiceImpl implements ActivityService {
  @Autowired
  ActivityRepository activityRespository;

  @Autowired
  SmartBandRepository smartBandRepository;

  @Override
  public Activity record(Activity activity) throws IllegalArgumentException, NotFoundException {
    if (!smartBandRepository.exists(activity.getSmartBand().getMac())) {
      throw new NotFoundException();
    }
    return activityRespository.save(activity);
  }


  @Override
  public List<Activity> getTodayActivity(String mac) throws IllegalArgumentException {
    java.util.Date date = new java.util.Date();
    Long currentDayStart = date.getTime() - date.getTime() % 86400000;
    return activityRespository.findBySmartBandAndTimestampAfterOrderByTimestampAsc(
        new SmartBand(mac), new Timestamp(currentDayStart));
  }


  @Override
  public List<Activity> getDateActivity(String mac, long timestamp) {
    java.util.Date date = new java.util.Date(timestamp);
    Long currentDayStart = date.getTime() - date.getTime() % 86400000;
    Long currentDayEnd = date.getTime() + date.getTime() % 86400000;
    return activityRespository.findBySmartBandAndTimestampBetweenOrderByTimestampAsc(
        new SmartBand(mac), new Timestamp(currentDayStart), new Timestamp(currentDayEnd));
  }

  @Override
  public List<Activity> getHighestActivity(String mac, long timestamp) {
    java.util.Date date = new java.util.Date(timestamp);
    Long currentDayStart = date.getTime() - date.getTime() % 86400000;
    Long currentDayEnd = date.getTime() + date.getTime() % 86400000;
    List<Activity> allActivity = new ArrayList<>();
    for (long i = currentDayStart; i < new java.util.Date().getTime(); i = i + 86400000) {
      List<Activity> dayActivity =
          activityRespository.findBySmartBandAndTimestampBetweenOrderByTimestampAsc(
              new SmartBand(mac), new Timestamp(currentDayStart), new Timestamp(currentDayEnd));
      Activity maxActivity = Collections.max(dayActivity, new Comparator<Activity>() {
        @Override
        public int compare(Activity o1, Activity o2) {
          if (o1.getSteps() > o2.getSteps()) {
            return 1;
          }
          return 0;
        }
      });

      allActivity.add(maxActivity);
    }
    return allActivity;
  }
}
