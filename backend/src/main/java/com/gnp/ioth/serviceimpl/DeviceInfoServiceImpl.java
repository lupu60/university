package com.gnp.ioth.serviceimpl;

import com.gnp.ioth.model.DeviceInfo;
import com.gnp.ioth.repository.DeviceInfoRepository;
import com.gnp.ioth.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {

  @Autowired
  DeviceInfoRepository deviceInfoRepository;

  @Override
  public DeviceInfo recordDeviceInfo(DeviceInfo deviceInfo) {
    return deviceInfoRepository.save(deviceInfo);
  }
}
