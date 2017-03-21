package com.gnp.ioth.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceInfoDTO {

	private final int appeareance;
	private final int feature;
	private final String fwVersion;
	private final String hrVersion;
	private final int hwVersion;

	@JsonCreator
	public DeviceInfoDTO(@JsonProperty("appearence") int appeareance, @JsonProperty("feature") int feature,
			@JsonProperty("fwVersion") String fwVersion, @JsonProperty("hwVersion") String hrVersion,
			@JsonProperty("deviceId") int hwVersion) {
		super();
		this.appeareance = appeareance;
		this.feature = feature;
		this.fwVersion = fwVersion;
		this.hrVersion = hrVersion;
		this.hwVersion = hwVersion;
	}

	public int getAppeareance() {
		return appeareance;
	}

	public int getFeature() {
		return feature;
	}

	public String getFwVersion() {
		return fwVersion;
	}

	public String getHrVersion() {
		return hrVersion;
	}

	public int getHwVersion() {
		return hwVersion;
	}

}
