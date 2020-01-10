package com.example.airportmanagementapp.controller;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.airportmanagementapp.dto.AirportDto;
import com.example.airportmanagementapp.dto.FlightDto;
import com.example.airportmanagementapp.entity.Airport;
import com.example.airportmanagementapp.entity.Flight;
import com.example.airportmanagementapp.entity.Passenger;
import com.example.airportmanagementapp.service.AirportManagementAppService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(AirportManagementAppController.class)
public class AirportManagementAppControllerTest {

	@Mock
	AirportManagementAppService aiportService;

	@InjectMocks
	AirportManagementAppController airportController;

	@Autowired
	MockMvc mockMvc;

	ModelMapper modelMapper = new ModelMapper();

//	@Bean
//	public ModelMapper ModelMapper() {
//		return new ModelMapper();
//	}

//	private AirportDto convertAirportEntityToDto(Airport airport) {
//		return modelMapper.map(airport, AirportDto.class);
//	}
//
//	private Airport convertAirportDtoToEntity(AirportDto airportDto) {
//		return modelMapper.map(airportDto, Airport.class);
//	}
//
//	private FlightDto convertFlightEntityToDto(Flight flight) {
//		return modelMapper.map(flight, FlightDto.class);
//	}
//
//	private Flight convertFlightDtoToEntity(FlightDto flightDto) {
//		return modelMapper.map(flightDto, Flight.class);
//	}
//
//	private PassengerDto convertPassengerEntityToDto(Passenger passenger) {
//		return modelMapper.map(passenger, PassengerDto.class);
//	}
//
//	private Passenger convertPassengerDtoToEntity(PassengerDto PassengerDto) {
//		return modelMapper.map(PassengerDto, Passenger.class);
//	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(airportController).build();
	}

	@Test
	public void testInsertAirport() throws Exception {
		Airport airport = new Airport();
		airport.setAirportId(1);
		airport.setAirportName("vizag");
		Set<Flight> flights = new HashSet<Flight>();
		Flight flight = new Flight();
		flight.setFlightId(1);
		flight.setFlightName("indian airlines");
		flights.add(flight);
		airport.setFlights(flights);
		// AirportDto airportDto = convertAirportEntityToDto(airport);
		AirportDto airportDto = modelMapper.map(airport, AirportDto.class);
		Mockito.when(aiportService.insertAirport(airport)).thenReturn(airportDto);
		mockMvc.perform(MockMvcRequestBuilders.post("/insertAirport").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(airportDto)).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void testFlightDtoinsertFlight() throws Exception {
		Flight flight = new Flight();
		flight.setFlightId(1);
		flight.setFlightName("indian airlines");
		flight.setTicketPrice(6000);
		Set<Passenger> passengers = new HashSet<Passenger>();
		Passenger passenger = new Passenger();
		passenger.setPassengerId(1);
		passenger.setPassengerName("lahari");
		passenger.setTicketCost(6000);
		passenger.setAge(16);
		passengers.add(passenger);
		flight.setPassengers(passengers);
		FlightDto flightDto = modelMapper.map(flight, FlightDto.class);
		Mockito.when(aiportService.insertFlight("vizag", flight)).thenReturn(flightDto);
		mockMvc.perform(MockMvcRequestBuilders.post("/insertFlight/vizag").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(flightDto)).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

//	@Test
//	public void testInsertPassenger() {
//		fail("Not yet implemented");
//	}
//
	@Test
	public void testSortByPassenger() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/sortByPassenger").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
