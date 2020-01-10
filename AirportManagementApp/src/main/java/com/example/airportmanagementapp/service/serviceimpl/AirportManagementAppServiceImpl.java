package com.example.airportmanagementapp.service.serviceimpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airportmanagementapp.dto.AirportDto;
import com.example.airportmanagementapp.dto.FlightDto;
import com.example.airportmanagementapp.dto.PassengerDto;
import com.example.airportmanagementapp.entity.Airport;
import com.example.airportmanagementapp.entity.Flight;
import com.example.airportmanagementapp.entity.Passenger;
import com.example.airportmanagementapp.exception.serviceexception.AirportManagementAppServiceException;
import com.example.airportmanagementapp.exception.serviceexception.FlightNotFoundException;
import com.example.airportmanagementapp.repository.AirportRepository;
import com.example.airportmanagementapp.repository.FlightRepository;
import com.example.airportmanagementapp.repository.PassengerRepository;
import com.example.airportmanagementapp.service.AirportManagementAppService;

@Service
public class AirportManagementAppServiceImpl implements AirportManagementAppService {

	@Autowired
	AirportRepository airportRepo;

	@Autowired
	FlightRepository flightRepo;

	@Autowired
	PassengerRepository passengerRepo;

//	@Autowired
//	ModelMapper modelMapper;
	ModelMapper modelMapper = new ModelMapper();

//	@Bean
//	public ModelMapper ModelMapper() {
//		return new ModelMapper();
//	}

	private AirportDto convertAirportEntityToDto(Airport airport) {
		return modelMapper.map(airport, AirportDto.class);
	}

	private Airport convertAirportDtoToEntity(AirportDto airportDto) {
		return modelMapper.map(airportDto, Airport.class);
	}

	private FlightDto convertFlightEntityToDto(Flight flight) {
		return modelMapper.map(flight, FlightDto.class);
	}

	private Flight convertFlightDtoToEntity(FlightDto flightDto) {
		return modelMapper.map(flightDto, Flight.class);
	}

	private PassengerDto convertPassengerEntityToDto(Passenger passenger) {
		return modelMapper.map(passenger, PassengerDto.class);
	}

	private Passenger convertPassengerDtoToEntity(PassengerDto PassengerDto) {
		return modelMapper.map(PassengerDto, Passenger.class);
	}

	@Override
	public AirportDto insertAirport(Airport airport) {

		Airport airport1 = airportRepo.save(airport);
		AirportDto airportDto = modelMapper.map(airport1, AirportDto.class);
		return airportDto;

	}

	@Override
	public FlightDto insertFlight(String airportName, Flight flight) {
		Airport airport = airportRepo.findByairportName(airportName);
		airport.getFlights().add(flight);
		flightRepo.save(flight);
		FlightDto flightDto = new FlightDto();
		flightDto = convertFlightEntityToDto(flight);
		return flightDto;

	}

	@Override
	public PassengerDto insertPassenger(String flightName, Passenger passenger)
			throws AirportManagementAppServiceException {
		Optional<Flight> flight = flightRepo.findByflightName(flightName);
		flight.orElseThrow(() -> new FlightNotFoundException("flight is not available..."));
		Passenger newpassenger = new Passenger();
		newpassenger.setPassengerName(passenger.getPassengerName());
		newpassenger.setAge(passenger.getAge());
		if (passenger.getAge() > 60) {
			int price = flight.get().getTicketPrice();
			int newPrice = (price * 20) / 100;
			newpassenger.setTicketCost(newPrice);
		} else {
			newpassenger.setTicketCost(flight.get().getTicketPrice());
		}
		newpassenger.setFlight(flight.get());
		passengerRepo.save(newpassenger);
		return convertPassengerEntityToDto(newpassenger);
	}

	@Override
	public List<PassengerDto> sortByPassenger() {
		List<Passenger> passengers = passengerRepo.findAll();
		Collections.sort(passengers);
		List<PassengerDto> passengerDtos = passengers.stream().map(i -> modelMapper.map(i, PassengerDto.class))
				.collect(Collectors.toList());
		return passengerDtos;
	}

}
