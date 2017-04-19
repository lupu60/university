package com.gnp.ioth.service;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.stereotype.Service;

import com.gnp.ioth.model.Activity;

@Service
public interface ActivityService {

  public Activity record(Activity activity) throws IllegalArgumentException, NotFoundException;

  public List<Activity> getTodayActivity(String mac) throws IllegalArgumentException;
  
  public List<Activity> getDateActivity(String mac, long timestamp);

  List<Activity> getHighestActivity(String mac);

}
