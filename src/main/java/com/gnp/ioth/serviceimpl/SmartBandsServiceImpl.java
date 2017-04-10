package com.gnp.ioth.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gnp.ioth.model.SmartBand;
import com.gnp.ioth.repository.SmartBandRepository;
import com.gnp.ioth.service.SmartBandService;

public class SmartBandsServiceImpl implements SmartBandService {
  @Autowired
  SmartBandRepository smartBandRepository;

  @Override
  public SmartBand create(SmartBand smartBand) throws IllegalArgumentException {
     return smartBandRepository.save(smartBand);
  }

  @Override
  public List<SmartBand> getAllSmartBands() {
    return smartBandRepository.findAll();
  }

}
