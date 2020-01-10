package com.example.airportmanagementapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PassengerDto {
	private int passengerId;
	private String passengerName;
	private int age;
	private int ticketCost;
	@JsonIgnoreProperties("passengerDtos")
	private FlightDto flightDto;

	public PassengerDto() {
		super();
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(int ticketCost) {
		this.ticketCost = ticketCost;
	}

	public FlightDto getFlightDto() {
		return flightDto;
	}

	public void setFlightDto(FlightDto flightDto) {
		this.flightDto = flightDto;
	}

	@Override
	public String toString() {
		return "PassengerDto [passengerId=" + passengerId + ", passengerName=" + passengerName + ", age=" + age
				+ ", ticketCost=" + ticketCost + ", flightDto=" + flightDto + "]";
	}

}
