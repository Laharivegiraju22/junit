package com.example.airportmanagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airportmanagementapp.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
