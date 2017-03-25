package com.gnp.ioth.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnp.ioth.model.DevicePower;
import com.gnp.ioth.repository.DevicePowerRepository;
import com.gnp.ioth.service.DevicePowerService;

@Service
public class DevicePowerServiceImpl implements DevicePowerService {

	@Autowired
	DevicePowerRepository devicePowerRepository;
	
	@Override
	public DevicePower update(DevicePower devicePower) throws IllegalArgumentException {
		if (devicePower == null)
			throw new IllegalArgumentException();
		devicePowerRepository.save(devicePower);
		return devicePower;
	}

	@Override
	public List<DevicePower> getAllDevicePowers() {
		List<DevicePower> target = new ArrayList<>();
		devicePowerRepository.findAll().forEach(target::add);
		return target;
	}

}
