package com.example.airportmanagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airportmanagementapp.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {

	Airport findByairportName(String airportName);

}
