package com.gnp.ioth.serviceimpl;

import com.gnp.ioth.model.SmartBand;
import com.gnp.ioth.repository.SmartBandRepository;
import com.gnp.ioth.service.SmartBandService;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartBandsServiceImpl implements SmartBandService {

  @Autowired
  SmartBandRepository smartBandRepository;

  @Override
  public SmartBand create(SmartBand smartBand) throws IllegalArgumentException {
    if (smartBandRepository.exists(smartBand.getMac())) {
      throw new IllegalArgumentException();
    }
    return smartBandRepository.save(smartBand);
  }

  @Override
  public List<SmartBand> getAllSmartBands() {
    return smartBandRepository.findAll();
  }

  @Override
  public SmartBand delete(String mac) throws NotFoundException {
    SmartBand band = smartBandRepository.findOne(mac);
    if (!smartBandRepository.exists(band.getMac())) {
      throw new NotFoundException(mac + " not found");
    }
    smartBandRepository.delete(mac);
    return band;
  }

}
