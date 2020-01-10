package com.example.airportmanagementapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Passenger implements Comparable<Passenger> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passengerId;
	private String passengerName;
	private int age;
	private int ticketCost;
	@ManyToOne
	private Flight flight;

	public Passenger() {
		super();
	}

	public Passenger(int passengerId, String passengerName, int age, int ticketCost, Flight flight) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.age = age;
		this.ticketCost = ticketCost;
		this.flight = flight;
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

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		result = prime * result + passengerId;
		result = prime * result + ((passengerName == null) ? 0 : passengerName.hashCode());
		result = prime * result + ticketCost;
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
		Passenger other = (Passenger) obj;
		if (age != other.age)
			return false;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (passengerId != other.passengerId)
			return false;
		if (passengerName == null) {
			if (other.passengerName != null)
				return false;
		} else if (!passengerName.equals(other.passengerName))
			return false;
		if (ticketCost != other.ticketCost)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", age=" + age
				+ ", ticketCost=" + ticketCost + ", flight=" + flight + "]";
	}

	@Override
	public int compareTo(Passenger passenger) {
		if (this.age == passenger.getAge()) {
			if (this.ticketCost == passenger.getTicketCost()) {
				return this.passengerName.compareToIgnoreCase(passenger.getPassengerName());
			} else {
				return this.ticketCost - passenger.getTicketCost();
			}
		} else {
			return this.age - passenger.getAge();
		}

	}

}
