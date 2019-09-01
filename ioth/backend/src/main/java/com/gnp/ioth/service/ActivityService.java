package com.gnp.ioth.service;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.stereotype.Service;

import com.gnp.ioth.model.Activity;

@Service
public interface ActivityService {

  Activity record(Activity activity) throws IllegalArgumentException, NotFoundException;

  List<Activity> getAllActivity();

  List<Activity> getTodayActivity(String mac) throws IllegalArgumentException, NotFoundException;

  List<Activity> getDateActivity(String mac, long timestamp) throws NotFoundException;

  List<Activity> getHighestActivity(String mac) throws NotFoundException;

}
