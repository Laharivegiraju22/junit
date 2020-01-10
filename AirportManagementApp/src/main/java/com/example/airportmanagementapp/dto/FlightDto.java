package com.example.airportmanagementapp.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class FlightDto {
	private int flightId;
	private String flightName;
	private int ticketPrice;
	@JsonIgnoreProperties("flightDto")
	Set<PassengerDto> passengerDtos;
	@JsonIgnoreProperties("flightDtos")
	private AirportDto aiportDto;

	public FlightDto() {
		super();
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Set<PassengerDto> getPassengerDtos() {
		return passengerDtos;
	}

	public void setPassengerDtos(Set<PassengerDto> passengerDtos) {
		this.passengerDtos = passengerDtos;
	}

	public AirportDto getAiportDto() {
		return aiportDto;
	}

	public void setAiportDto(AirportDto aiportDto) {
		this.aiportDto = aiportDto;
	}

	@Override
	public String toString() {
		return "FlightDto [flightId=" + flightId + ", flightName=" + flightName + ", ticketPrice=" + ticketPrice
				+ ", passengerDtos=" + passengerDtos + ", aiportDto=" + aiportDto + "]";
	}

}
