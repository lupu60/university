package com.gnp.ioth.serviceimpl;

import java.sql.Timestamp;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.Patient;
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
  public List<Activity> get(Patient patient) throws IllegalArgumentException, NotFoundException {
    return activityRespository.findBySmartBand(patient.getSmartBand());
  }

  @Override
  public List<Activity> getTodayActivity(Patient patient) throws IllegalArgumentException {
    java.util.Date date = new java.util.Date();
    Long currentDayStart = date.getTime() - date.getTime() % 86400000;
    return activityRespository.findBySmartBandAndTimestampAfterOrderByTimestampDesc(
        patient.getSmartBand(), new Timestamp(currentDayStart));
  }

  @Override
  public List<Activity> get(SmartBand smartBand) throws IllegalArgumentException, NotFoundException {
    return activityRespository.findBySmartBand(smartBand);
  }

}
