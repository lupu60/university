package com.gnp.ioth.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class GatewayController {
  private static final Logger LOG = LoggerFactory.getLogger(GatewayController.class);

  @RequestMapping(value = "/steps", method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody String createPatient(@RequestBody String steps) {
    LOG.info("Gateway");
    return "gateway";
  }

}
