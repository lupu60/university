package com.gnp.ioth.service;

import java.util.List;

import com.gnp.ioth.model.DeviceInfo;

public interface DeviceInfoService {
	public DeviceInfo create(DeviceInfo deviceInfo) throws IllegalArgumentException;

	public List<DeviceInfo> getAllDeviceInfo();
}
