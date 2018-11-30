package com.gnp.ioth.service;

import com.gnp.ioth.model.SmartBand;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface SmartBandService {

  SmartBand create(SmartBand smartBand) throws IllegalArgumentException;

  SmartBand delete(String mac) throws NotFoundException;

  List<SmartBand> getAllSmartBands();
}
