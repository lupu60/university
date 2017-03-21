package com.gnp.ioth.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnp.ioth.model.DevicePower;
import com.gnp.ioth.model.dto.BatteryInfoDTO;
import com.gnp.ioth.model.dto.DeviceDTO;
import com.gnp.ioth.service.DevicePowerService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/gateway")
public class GatewayController {

	private static final Logger LOG = LoggerFactory.getLogger(GatewayController.class);

	@Autowired
	private DevicePowerService devicePowerService;

	@RequestMapping(value = "/steps", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String createPatient(@RequestBody String steps) {
		LOG.info("Gateway");
		return "gateway";
	}

	@RequestMapping(value = "/device/{id}", method = RequestMethod.POST, consumes = "application/json")
	public void updateDevice(@RequestBody DeviceDTO deviceDto) {
		LOG.info("Received deviceDto" + deviceDto);
		devicePowerService.update(getDevicePower(deviceDto));
	}

	private DevicePower getDevicePower(DeviceDTO deviceDto) {
		BatteryInfoDTO battInfoDto = deviceDto.getBatteryInfo();
		return new DevicePower(battInfoDto.getPowerLevel(), battInfoDto.getPowerStatus(),
				battInfoDto.getNumberOfCharges(), deviceDto.getDeviceId(), deviceDto.getTimestamp());
	}

}
