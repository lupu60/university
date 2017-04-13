package com.gnp.ioth.service;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.stereotype.Service;

import com.gnp.ioth.model.Activity;
import com.gnp.ioth.model.Patient;
import com.gnp.ioth.model.SmartBand;

@Service
public interface ActivityService {

  public Activity record(Activity activity) throws IllegalArgumentException, NotFoundException;

  public List<Activity> get(Patient patient) throws IllegalArgumentException, NotFoundException;

  public List<Activity> getTodayActivity(Patient patient) throws IllegalArgumentException;

  public List<Activity> get(SmartBand smartBand) throws IllegalArgumentException, NotFoundException;

}
