package com.gnp.ioth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gnp.ioth.model.SmartBand;

import javassist.NotFoundException;

@Service
public interface SmartBandService {
  public SmartBand create(SmartBand smartBand) throws IllegalArgumentException;

  public SmartBand delete(String mac) throws NotFoundException;

  public List<SmartBand> getAllSmartBands();
}
