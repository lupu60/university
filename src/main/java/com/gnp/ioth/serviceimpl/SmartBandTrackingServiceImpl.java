package com.gnp.ioth.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.gnp.ioth.model.Steps;
import com.gnp.ioth.repository.StepsRepository;
import com.gnp.ioth.service.SmartBandTrackingService;

public class SmartBandTrackingServiceImpl implements SmartBandTrackingService {
  @Autowired
  StepsRepository stepsRepository;

  @Override
  public Steps recordSteps(Steps steps) throws IllegalArgumentException {
    return stepsRepository.save(steps);
  }

}
