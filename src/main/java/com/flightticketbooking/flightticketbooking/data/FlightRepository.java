package com.flightticketbooking.flightticketbooking.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long>{
	Optional<Flight> findByName(String flightName);

	Flight findFlightById(Long flightId);
}
