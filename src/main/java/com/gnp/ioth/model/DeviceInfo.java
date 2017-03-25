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

	@Column(name = "deviceInfoHwVersion")
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

	public DeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeviceInfo(String deviceId, Timestamp timestamp, int deviceInfoFeature, String deviceInfoHrVersion,
			String deviceInfoHwVersion, String deviceInfoFwVersion, String deviceInfoApperence,
			int batteryInfoNumberOfCharges, int batteryInfoPowerLevel, String batteryInfoPowerStatus) {
		super();
		this.deviceId = deviceId;
		this.timestamp = timestamp;
		this.deviceInfoFeature = deviceInfoFeature;
		this.deviceInfoHrVersion = deviceInfoHrVersion;
		this.deviceInfoHwVersion = deviceInfoHwVersion;
		this.deviceInfoFwVersion = deviceInfoFwVersion;
		this.deviceInfoApperence = deviceInfoApperence;
		this.batteryInfoNumberOfCharges = batteryInfoNumberOfCharges;
		this.batteryInfoPowerLevel = batteryInfoPowerLevel;
		this.batteryInfoPowerStatus = batteryInfoPowerStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getDeviceInfoFeature() {
		return deviceInfoFeature;
	}

	public void setDeviceInfoFeature(int deviceInfoFeature) {
		this.deviceInfoFeature = deviceInfoFeature;
	}

	public String getDeviceInfoHrVersion() {
		return deviceInfoHrVersion;
	}

	public void setDeviceInfoHrVersion(String deviceInfoHrVersion) {
		this.deviceInfoHrVersion = deviceInfoHrVersion;
	}

	public String getDeviceInfoHwVersion() {
		return deviceInfoHwVersion;
	}

	public void setDeviceInfoHwVersion(String deviceInfoHwVersion) {
		this.deviceInfoHwVersion = deviceInfoHwVersion;
	}

	public String getDeviceInfoFwVersion() {
		return deviceInfoFwVersion;
	}

	public void setDeviceInfoFwVersion(String deviceInfoFwVersion) {
		this.deviceInfoFwVersion = deviceInfoFwVersion;
	}

	public String getDeviceInfoApperence() {
		return deviceInfoApperence;
	}

	public void setDeviceInfoApperence(String deviceInfoApperence) {
		this.deviceInfoApperence = deviceInfoApperence;
	}

	public int getBatteryInfoNumberOfCharges() {
		return batteryInfoNumberOfCharges;
	}

	public void setBatteryInfoNumberOfCharges(int batteryInfoNumberOfCharges) {
		this.batteryInfoNumberOfCharges = batteryInfoNumberOfCharges;
	}

	public int getBatteryInfoPowerLevel() {
		return batteryInfoPowerLevel;
	}

	public void setBatteryInfoPowerLevel(int batteryInfoPowerLevel) {
		this.batteryInfoPowerLevel = batteryInfoPowerLevel;
	}

	public String getBatteryInfoPowerStatus() {
		return batteryInfoPowerStatus;
	}

	public void setBatteryInfoPowerStatus(String batteryInfoPowerStatus) {
		this.batteryInfoPowerStatus = batteryInfoPowerStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batteryInfoNumberOfCharges;
		result = prime * result + batteryInfoPowerLevel;
		result = prime * result + ((batteryInfoPowerStatus == null) ? 0 : batteryInfoPowerStatus.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((deviceInfoApperence == null) ? 0 : deviceInfoApperence.hashCode());
		result = prime * result + deviceInfoFeature;
		result = prime * result + ((deviceInfoFwVersion == null) ? 0 : deviceInfoFwVersion.hashCode());
		result = prime * result + ((deviceInfoHrVersion == null) ? 0 : deviceInfoHrVersion.hashCode());
		result = prime * result + ((deviceInfoHwVersion == null) ? 0 : deviceInfoHwVersion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceInfo other = (DeviceInfo) obj;
		if (batteryInfoNumberOfCharges != other.batteryInfoNumberOfCharges)
			return false;
		if (batteryInfoPowerLevel != other.batteryInfoPowerLevel)
			return false;
		if (batteryInfoPowerStatus == null) {
			if (other.batteryInfoPowerStatus != null)
				return false;
		} else if (!batteryInfoPowerStatus.equals(other.batteryInfoPowerStatus))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (deviceInfoApperence == null) {
			if (other.deviceInfoApperence != null)
				return false;
		} else if (!deviceInfoApperence.equals(other.deviceInfoApperence))
			return false;
		if (deviceInfoFeature != other.deviceInfoFeature)
			return false;
		if (deviceInfoFwVersion == null) {
			if (other.deviceInfoFwVersion != null)
				return false;
		} else if (!deviceInfoFwVersion.equals(other.deviceInfoFwVersion))
			return false;
		if (deviceInfoHrVersion == null) {
			if (other.deviceInfoHrVersion != null)
				return false;
		} else if (!deviceInfoHrVersion.equals(other.deviceInfoHrVersion))
			return false;
		if (deviceInfoHwVersion == null) {
			if (other.deviceInfoHwVersion != null)
				return false;
		} else if (!deviceInfoHwVersion.equals(other.deviceInfoHwVersion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DeviceInfo [id=" + id + ", deviceId=" + deviceId + ", timestamp=" + timestamp + ", deviceInfoFeature="
				+ deviceInfoFeature + ", deviceInfoHrVersion=" + deviceInfoHrVersion + ", deviceInfoHwVersion="
				+ deviceInfoHwVersion + ", deviceInfoFwVersion=" + deviceInfoFwVersion + ", deviceInfoApperence="
				+ deviceInfoApperence + ", batteryInfoNumberOfCharges=" + batteryInfoNumberOfCharges
				+ ", batteryInfoPowerLevel=" + batteryInfoPowerLevel + ", batteryInfoPowerStatus="
				+ batteryInfoPowerStatus + "]";
	}

}
