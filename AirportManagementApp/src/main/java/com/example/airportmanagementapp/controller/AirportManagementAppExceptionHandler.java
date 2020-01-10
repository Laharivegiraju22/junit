package com.example.airportmanagementapp.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.airportmanagementapp.dto.ErrorDto;
import com.example.airportmanagementapp.exception.serviceexception.FlightNotFoundException;

@RestControllerAdvice
public class AirportManagementAppExceptionHandler {
	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<Map<String, Object>> flightNotFoundException(FlightNotFoundException e, Throwable cause) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("Header", "AirportManagement");
		response.put("Error", true);
		ErrorDto errorMessage = new ErrorDto();
		errorMessage.setMessage(e.getMessage());
		response.put("Body", errorMessage);
		response.put("HttpStatus", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	}
}
