package com.gnp.ioth.service;

import com.gnp.ioth.model.Steps;

public interface SmartBandTrackingService {
  public Steps recordSteps(Steps steps) throws IllegalArgumentException;
  // TODO recordHR, recordSleep, recordETC
}
