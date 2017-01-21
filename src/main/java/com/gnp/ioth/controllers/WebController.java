package com.gnp.ioth.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi")
public class WebController {

  // @SuppressWarnings("unused")
  // private LeshanServerWrapper leshanServerWrapper = new LeshanServerWrapper();
  private static final Logger LOG = LoggerFactory.getLogger(WebController.class);

  @RequestMapping(method = RequestMethod.GET)
  public String hello() {
    LOG.info("hello");
    return "Welcome to IoT Healthcare";
  }
}
