package com.gnp.ioth.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnp.ioth.model.SmartBand;
import com.gnp.ioth.service.SmartBandService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/webapi/smartband")
public class SmartBandController {

  @Autowired
  SmartBandService smartBandService;

  private static final Logger LOG = LoggerFactory.getLogger(SmartBandController.class);

  @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
  public List<SmartBand> getAllSmartBands() {
    return smartBandService.getAllSmartBands();
  }

  @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody SmartBand createSmartBand(@RequestBody SmartBand smartBand)
      throws IllegalArgumentException {
    LOG.info(smartBand.toString());
    return smartBandService.create(smartBand);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
  public @ResponseBody SmartBand deleteSmartBand(@PathVariable("id") String mac)
      throws NotFoundException {
    LOG.info(mac);
    return smartBandService.delete(mac);
  }
}
