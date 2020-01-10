package com.example.airportmanagementapp.service.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.airportmanagementapp.dto.AirportDto;
import com.example.airportmanagementapp.dto.PassengerDto;
import com.example.airportmanagementapp.entity.Airport;
import com.example.airportmanagementapp.entity.Flight;
import com.example.airportmanagementapp.entity.Passenger;
import com.example.airportmanagementapp.repository.AirportRepository;
import com.example.airportmanagementapp.repository.FlightRepository;
import com.example.airportmanagementapp.repository.PassengerRepository;
import com.example.airportmanagementapp.service.AirportManagementAppService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class AirportManagementAppServiceImplTest {
	@Mock
	PassengerRepository passengerRepo;

	@Mock
	AirportRepository airportRepo;

	@Mock
	FlightRepository flightRepo;

	ModelMapper mapper = new ModelMapper();

	@InjectMocks
	AirportManagementAppService service = new AirportManagementAppServiceImpl();

	ModelMapper modelMapper = new ModelMapper();
//	@Override
//	public AirportDto insertAirport(Airport airport) {
//
//		Airport airport1 = airportRepo.save(airport);
//		AirportDto airportDto = convertAirportEntityToDto(airport1);
//		return airportDto;
//
//	}

	@Test
	void testInsertAirport() {

		Set<Flight> flights = new HashSet<Flight>();
		Set<Passenger> passengers = new HashSet<Passenger>();
		Passenger passenger = new Passenger(1, "lahari", 21, 6000, null);
		passengers.add(passenger);
		Flight flight = new Flight(1, "abc", 6000, passengers);
		flights.add(flight);
		Airport airport1 = new Airport(1, "vizag", flights);
		AirportDto airportDto = mapper.map(airport1, AirportDto.class);

		Airport airport = new Airport(1, "vizag", flights);
		Mockito.when(airportRepo.save(Mockito.any(Airport.class))).thenReturn(airport1);
		AirportDto savedDto = mapper.map(airport, AirportDto.class);
		assertEquals(airportDto.getAirportId(), service.insertAirport(airport).getAirportId());

	}

//	@Override
//	public FlightDto insertFlight(String airportName, Flight flight) {
//		Airport airport = airportRepo.findByairportName(airportName);
//		airport.getFlights().add(flight);
//		flightRepo.save(flight);
//		FlightDto flightDto = new FlightDto();
//		flightDto = convertFlightEntityToDto(flight);
//		return flightDto;
//
//	}

	@Test
	void testInsertFlight() {
		Flight flight = new Flight();
		flight.setFlightId(1);
		flight.setFlightName("indian airlines");
		flight.setTicketPrice(6000);
		Mockito.when(flightRepo.save(Mockito.any(Flight.class))).thenReturn(flight);

	}

//	@Test
//	void testInsertPassenger() {
//		fail("Not yet implemented");
//	}

	@Test
	void testSortByPassenger() {
		List<Passenger> passengers = new ArrayList<Passenger>();
		Passenger passenger = new Passenger();
		passenger.setPassengerId(1);
		passenger.setPassengerName("lahari");
		passenger.setTicketCost(6000);
		passenger.setAge(21);
		passengers.add(passenger);

		Mockito.when(passengerRepo.findAll()).thenReturn(passengers);
		Collections.sort(passengers);
		List<PassengerDto> passengers1 = passengers.stream().map(i -> modelMapper.map(i, PassengerDto.class))
				.collect(Collectors.toList());
		List<PassengerDto> passengers11 = this.service.sortByPassenger();
		assertEquals(passengers1.get(0).getPassengerId(), passengers11.get(0).getPassengerId());

	}

}
