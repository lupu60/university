package com.gnp.ioth.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Device")
public class DevicePower {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "powerLevel")
	private int powerLevel;

	@Column(name = "powerStatus")
	private String powerStatus;

	@Column(name = "noOfCharges")
	private int numberOfCharges;

	@Column(name = "deviceId")
	private String deviceId;

	@Column(name = "timeStamp")
	private String timeStamp;

	public DevicePower() {
		super();
	}

	public DevicePower(int powerLevel, String powerStatus, int numerOfCharges, String deviceId, String timeStamp) {
		super();
		this.powerLevel = powerLevel;
		this.powerStatus = powerStatus;
		this.numberOfCharges = numerOfCharges;
		this.deviceId = deviceId;
		this.timeStamp = timeStamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, powerLevel, powerStatus, numberOfCharges);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof DevicePower)) {
			return false;
		}
		DevicePower device = (DevicePower) o;
		return id == device.id && powerLevel == device.powerLevel && Objects.equals(powerStatus, device.powerStatus)
				&& numberOfCharges == device.numberOfCharges && Objects.equals(deviceId, device.deviceId)
				&& Objects.equals(timeStamp, device.timeStamp);
	}

	@Override
	public String toString() {
		return "Device [id=" + id + " powerLevel=" + powerLevel + " powerStatus=" + powerStatus;
	}

}
