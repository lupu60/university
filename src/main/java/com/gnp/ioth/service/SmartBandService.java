package com.gnp.ioth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gnp.ioth.model.SmartBand;
@Service
public interface SmartBandService {
  public SmartBand create(SmartBand smartBand) throws IllegalArgumentException;

  public List<SmartBand> getAllSmartBands();
}
