package com.gnp.ioth.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class DeviceMonitoring {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @ManyToOne
  private SmartBand smartBand;
}
