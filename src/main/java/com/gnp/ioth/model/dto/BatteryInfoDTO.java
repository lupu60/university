package com.gnp.ioth.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BatteryInfoDTO {

	private final int numberOfCharges;
	private final int powerLevel;
	private final String powerStatus;

	@JsonCreator
	public BatteryInfoDTO(@JsonProperty("numberOfCharges") int numberOfCharges,
			@JsonProperty("powerLevel") int powerLevel, @JsonProperty("powerStatus") String powerStatus) {
		super();
		this.numberOfCharges = numberOfCharges;
		this.powerLevel = powerLevel;
		this.powerStatus = powerStatus;
	}

	public int getNumberOfCharges() {
		return numberOfCharges;
	}

	public int getPowerLevel() {
		return powerLevel;
	}

	public String getPowerStatus() {
		return powerStatus;
	}

}
