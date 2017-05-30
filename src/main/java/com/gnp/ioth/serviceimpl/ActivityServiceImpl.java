package com.gnp.ioth.serviceimpl;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.SmartBand;
import com.gnp.ioth.repository.ActivityRepository;
import com.gnp.ioth.repository.SmartBandRepository;
import com.gnp.ioth.service.ActivityService;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    activity.getHeartRate().remove(Collections.min(activity.getHeartRate()));
    activity.getHeartRate().remove(Collections.max(activity.getHeartRate()));
    return activityRespository.save(activity);
  }


  @Override
  public List<Activity> getTodayActivity(String mac) throws IllegalArgumentException {
    return activityRespository.findBySmartBandAndTimestampAfterOrderByTimestampAsc(
        new SmartBand(mac),
        new Timestamp(new GregorianCalendar(new GregorianCalendar().get(Calendar.YEAR),
            new GregorianCalendar().get(Calendar.MONTH),
            new GregorianCalendar().get(Calendar.DAY_OF_MONTH)).getTimeInMillis()));
  }


  @Override
  public List<Activity> getDateActivity(String mac, long timestamp) {
    Calendar cal = new GregorianCalendar();
    cal.setTimeInMillis(timestamp);
    Long currentDayStart = cal.getTimeInMillis() - cal.getTimeInMillis() % 86400000;
    Long currentDayEnd = cal.getTimeInMillis() + cal.getTimeInMillis() % 86400000;
    return activityRespository.findBySmartBandAndTimestampBetweenOrderByTimestampAsc(
        new SmartBand(mac), new Timestamp(currentDayStart), new Timestamp(currentDayEnd));
  }


  @Override
  public List<Activity> getHighestActivity(String mac) {
    List<Activity> allActivity = new ArrayList<>();
    Calendar cal = new GregorianCalendar();
    for (long i = new GregorianCalendar(new GregorianCalendar().get(Calendar.YEAR),
        new GregorianCalendar().get(Calendar.MONTH), 1)
            .getTimeInMillis(); i < new GregorianCalendar(
                new GregorianCalendar().get(Calendar.YEAR),
                new GregorianCalendar().get(Calendar.MONTH),
                new GregorianCalendar().get(Calendar.DAY_OF_MONTH)).getTimeInMillis(); i =
                    i + 86400000) {
      cal.setTimeInMillis(i);
      List<Activity> dayActivity =
          activityRespository.findBySmartBandAndTimestampBetweenOrderByTimestampAsc(
              new SmartBand(mac), new Timestamp(cal.getTimeInMillis()),
              new Timestamp(cal.getTimeInMillis() + 86400000));
      if (dayActivity != null && !dayActivity.isEmpty()) {
        Activity maxActivity = Collections.max(dayActivity, new Comparator<Activity>() {
          @Override
          public int compare(Activity o1, Activity o2) {
            if (o1.getSteps() >= o2.getSteps()) {
              return 1;
            }
            return 0;
          }
        });
        allActivity.add(maxActivity);
      }
    }
    return allActivity;
  }
}
