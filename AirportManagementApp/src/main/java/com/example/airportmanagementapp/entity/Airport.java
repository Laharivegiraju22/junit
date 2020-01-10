package com.example.airportmanagementapp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int airportId;
	private String airportName;
	@OneToMany(cascade = CascadeType.PERSIST)
	Set<Flight> flights;

	public Airport() {
		super();
	}

	public Airport(int airportId, String airportName, Set<Flight> flights) {
		super();
		this.airportId = airportId;
		this.airportName = airportName;
		this.flights = flights;
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

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", airportName=" + airportName + ", flights=" + flights + "]";
	}

}
