package com.gnp.ioth.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceDTO {

	private final String deviceId;

	private final String timestamp;

	private final BatteryInfoDTO batteryInfo;

	private final DeviceInfoDTO deviceInfo;

	@JsonCreator()
	public DeviceDTO(@JsonProperty("deviceId") String deviceId, @JsonProperty("timestamp") String timestamp, //
			@JsonProperty("batteryInfo") BatteryInfoDTO batteryInfo, 
			@JsonProperty("deviceInfo") DeviceInfoDTO deviceInfo) { 
		super();
		this.deviceId = deviceId;
		this.timestamp = timestamp;
		this.batteryInfo = batteryInfo;
		this.deviceInfo = deviceInfo;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public BatteryInfoDTO getBatteryInfo() {
		return batteryInfo;
	}

	public DeviceInfoDTO getDeviceInfo() {
		return deviceInfo;
	}

}
