package com.gnp.ioth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebController {
  @RequestMapping(method = RequestMethod.GET)
  public String hello() {
    return "hello";
  }
}
