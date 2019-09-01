package com.gnp.ioth.service;


import org.springframework.stereotype.Service;

import com.gnp.ioth.model.DeviceInfo;

@Service
public interface DeviceInfoService {

  DeviceInfo recordDeviceInfo(DeviceInfo deviceInfo);
}
