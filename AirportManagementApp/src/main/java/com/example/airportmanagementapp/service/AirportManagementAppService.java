package com.example.airportmanagementapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.airportmanagementapp.dto.AirportDto;
import com.example.airportmanagementapp.dto.FlightDto;
import com.example.airportmanagementapp.dto.PassengerDto;
import com.example.airportmanagementapp.entity.Airport;
import com.example.airportmanagementapp.entity.Flight;
import com.example.airportmanagementapp.entity.Passenger;
import com.example.airportmanagementapp.exception.serviceexception.AirportManagementAppServiceException;

@Service
public interface AirportManagementAppService {

	AirportDto insertAirport(Airport airport);

	FlightDto insertFlight(String airportName, Flight flight);

	PassengerDto insertPassenger(String flightName, Passenger passenger) throws AirportManagementAppServiceException;

	List<PassengerDto> sortByPassenger();

}
