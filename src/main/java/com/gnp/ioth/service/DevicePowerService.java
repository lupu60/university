package com.gnp.ioth.service;

import java.util.List;

import com.gnp.ioth.model.DevicePower;

public interface DevicePowerService {

	  public DevicePower update(DevicePower devicePower) throws IllegalArgumentException;

	  public List<DevicePower> getAllDevicePowers();

}
