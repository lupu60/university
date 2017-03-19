package com.gnp.ioth.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Device_info")
public class DeviceInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "deviceId")
	private String deviceId;
	
	@Column(name = "timestamp")
	private Timestamp timestamp;
	
	@Column(name = "deviceInfoFeature")
	private int deviceInfoFeature;
	
	@Column(name = "deviceInfoHrVersion")
	private String deviceInfoHrVersion;
	
	@Column(name = "deviceInfoFeature")
	private String deviceInfoHwVersion;
	
	@Column(name = "deviceInfoFwVersion")
	private String deviceInfoFwVersion;
	
	@Column(name = "deviceInfoApperence")
	private String deviceInfoApperence;
	
	@Column(name = "batteryInfoNumberOfCharges")
	private int batteryInfoNumberOfCharges;
	
	@Column(name = "batteryInfoPowerLevel")
	private int batteryInfoPowerLevel;
	
	@Column(name = "batteryInfoPowerStatus")
	private String batteryInfoPowerStatus;
}
