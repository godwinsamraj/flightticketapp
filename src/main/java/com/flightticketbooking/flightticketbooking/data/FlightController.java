package com.flightticketbooking.flightticketbooking.data;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/flight")
@CrossOrigin
public class FlightController {
	private final FlightService flightService;
	public FlightController(FlightService flightService) {
		this.flightService=flightService;
	}
	@GetMapping
	public List<Flight> getFlight(){
		return flightService.getFlight();
	}
	@GetMapping("/bookedTickets/{flightId}")
	public List<User> getBookedTickets(@PathVariable("flightId") Long flightId){
		return flightService.getBookedTickets(flightId);
	}
	@PostMapping("/add")
	public Boolean registerNewFlight(@RequestBody Flight flight) {
		return flightService.addNewFlight(flight);
	}
	@DeleteMapping("/delete/{flightId}")
	public Boolean deleteFlight(@PathVariable("flightId") Long flightId) {
		return flightService.deleteFlight(flightId);
	} 
	@PutMapping("/update/{flightName}")
	public void updateFlight(@RequestBody Flight newFlight,@PathVariable("flightName") String flightName) {
		flightService.updateFlight(newFlight,flightName);
	}
}
