package com.example.airportmanagementapp.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.airportmanagementapp.dto.AirportDto;
import com.example.airportmanagementapp.dto.PassengerDto;
import com.example.airportmanagementapp.entity.Airport;
import com.example.airportmanagementapp.entity.Flight;
import com.example.airportmanagementapp.entity.Passenger;
import com.example.airportmanagementapp.exception.serviceexception.AirportManagementAppServiceException;
import com.example.airportmanagementapp.service.AirportManagementAppService;

@RestController
public class AirportManagementAppController {

	@Autowired
	AirportManagementAppService airportServiceImpl;

	@PostMapping("/insertAirport")
	public ResponseEntity<AirportDto> insertAirport(@RequestBody Airport airport) {

		return ResponseEntity.status(HttpStatus.OK).body(airportServiceImpl.insertAirport(airport));
	}

	@PostMapping("/insertFlight/{airportName}")
	public ResponseEntity<Map<String, Object>> FlightDtoinsertFlight(@PathVariable String airportName,
			@RequestBody Flight flight) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("Header", "AirportManagement");
		response.put("Error", false);
		response.put("Body", airportServiceImpl.insertFlight(airportName, flight));
		response.put("HttpStatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@PostMapping("/insertPassenger/{flightName}")
	public ResponseEntity<PassengerDto> insertPassenger(@PathVariable String flightName,
			@RequestBody Passenger passenger) throws AirportManagementAppServiceException {
		return ResponseEntity.status(HttpStatus.OK).body(airportServiceImpl.insertPassenger(flightName, passenger));

	}

	@GetMapping("/sortByPassenger")
	public List<PassengerDto> sortByPassenger() {
		return airportServiceImpl.sortByPassenger();
	}
}
