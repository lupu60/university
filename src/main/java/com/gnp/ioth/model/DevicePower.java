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

	public enum PowerStatus {
		NORMAL, LOW, CHARGING, FULL, CHARGE_OFF
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "bandId")
	private String bandId;

	@Column(name = "powerLevel")
	private int powerLevel;

	@Column(name = "powerStatus")
	private PowerStatus powerStatus;

	@Column(name = "noOfCharges")
	private int numberOfCharges;

	public DevicePower(){
		super();
	}
	
	public DevicePower(String bandId, int powerLevel, PowerStatus powerStatus, int numerOfCharges) {
		super();
		this.bandId = bandId;
		this.powerLevel = powerLevel;
		this.powerStatus = powerStatus;
		this.numberOfCharges = numerOfCharges;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, bandId, powerLevel, powerStatus, numberOfCharges);
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
		return id == device.id && Objects.equals(bandId, device.bandId) && powerLevel == device.powerLevel
				&& Objects.equals(powerStatus, device.powerStatus) && numberOfCharges == device.numberOfCharges;
	}
	
	@Override
	public String toString() {
		return "Device [id="+id+" bandId="+bandId+" powerLevel="+powerLevel+" powerStatus="+powerStatus;
	}

}
