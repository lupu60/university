package com.gnp.ioth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnp.ioth.model.SmartBand;
import com.gnp.ioth.service.SmartBandService;

@RestController
@RequestMapping("/webapi/smartband")
public class SmartBandController {
  
  @Autowired
  SmartBandService smartBandService;

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
  public List<SmartBand> getAllSmartBands() {
    return smartBandService.getAllSmartBands();
  }

  @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody SmartBand createBands(@RequestBody SmartBand smartBand)
      throws IllegalArgumentException {
    return smartBandService.create(smartBand);
  }
}
