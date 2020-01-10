package com.example.airportmanagementapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airportmanagementapp.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	Optional<Flight> findByflightName(String flightName);

}
