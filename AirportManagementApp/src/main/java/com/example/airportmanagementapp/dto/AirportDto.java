package com.example.airportmanagementapp.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class AirportDto {
	private int airportId;
	private String airportName;
	@JsonIgnoreProperties("aiportDto")
	Set<FlightDto> flightDtos;

	public AirportDto() {
		super();
	}

	public int getAirportId() {
		return airportId;
	}

	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public Set<FlightDto> getFlightDtos() {
		return flightDtos;
	}

	public void setFlightDtos(Set<FlightDto> flightDtos) {
		this.flightDtos = flightDtos;
	}

	@Override
	public String toString() {
		return "AirportDto [airportId=" + airportId + ", airportName=" + airportName + ", flightDtos=" + flightDtos
				+ "]";
	}

}
