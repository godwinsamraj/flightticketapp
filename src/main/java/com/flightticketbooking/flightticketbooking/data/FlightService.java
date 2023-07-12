package com.flightticketbooking.flightticketbooking.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class FlightService {
	private final FlightRepository flightRepository;
	private final UserRepository userRepository;
	public FlightService(FlightRepository flightRepository,UserRepository userRepository) {
		this.flightRepository=flightRepository;
		this.userRepository=userRepository;
	}
	public List<Flight> getFlight() {
		return flightRepository.findAll();
	}
	public Boolean addNewFlight(Flight flight) {
		flightRepository.save(flight);
		return true;
	}
	public Boolean deleteFlight(Long flightId) {
		if(!flightRepository.existsById(flightId)) return false;
		flightRepository.deleteById(flightId);
		return true;
	}
	public List<User> getBookedTickets(Long flightId){
		List<User> list=new ArrayList<User>();
		Flight flight=flightRepository.findFlightById(flightId);
		String[] arr=flight.getBookedTickets().split("[-]+");
		for(int i=0;i<arr.length;i++) list.add(userRepository.findUserById(Long.parseLong(arr[i])));
		return list;
	}
	@Transactional
	public void updateFlight(Flight newFlight, String flightName) {
		Flight flight=flightRepository.findByName(flightName)
				.orElseThrow(()->new IllegalStateException("flight with name:"+flightName+"does not exists"));
		if(newFlight.getName()!=null && newFlight.getName().length()>0 && !Objects.equals(flight.getName(),newFlight.getName()))
			flight.setName(newFlight.getName());
		if(newFlight.getArrivalHour()!=null && newFlight.getArrivalHour()>-1 && !Objects.equals(flight.getArrivalHour(),newFlight.getArrivalHour()))
			flight.setArrivalHour(newFlight.getArrivalHour());
		if(newFlight.getArrivalMinute()!=null && newFlight.getArrivalMinute()>-1 && !Objects.equals(flight.getArrivalMinute(),newFlight.getArrivalMinute()))
			flight.setArrivalMinute(newFlight.getArrivalMinute());
		if(newFlight.getArrivalDate()!=null && newFlight.getArrivalDate()>-1 && !Objects.equals(flight.getArrivalDate(),newFlight.getArrivalDate()))
			flight.setArrivalDate(newFlight.getArrivalDate());
		if(newFlight.getArrivalMonth()!=null && newFlight.getArrivalMonth()>-1 && !Objects.equals(flight.getArrivalMonth(),newFlight.getArrivalMonth()))
			flight.setArrivalMonth(newFlight.getArrivalMonth());
		if(newFlight.getArrivalYear()!=null && newFlight.getArrivalYear()>-1 && !Objects.equals(flight.getArrivalYear(),newFlight.getArrivalYear()))
			flight.setArrivalYear(newFlight.getArrivalYear());
		if(newFlight.getArrivalLocation()!=null && newFlight.getArrivalLocation().length()>0 && !Objects.equals(flight.getArrivalLocation(),newFlight.getArrivalLocation()))
			flight.setArrivalLocation(newFlight.getArrivalLocation());
		if(newFlight.getDepatureHour()!=null && newFlight.getDepatureHour()>-1 && !Objects.equals(flight.getDepatureHour(),newFlight.getDepatureHour()))
			flight.setDepatureHour(newFlight.getDepatureHour());
		if(newFlight.getDepatureMinute()!=null && newFlight.getDepatureMinute()>-1 && !Objects.equals(flight.getDepatureMinute(),newFlight.getDepatureMinute()))
			flight.setDepatureMinute(newFlight.getDepatureMinute());
		if(newFlight.getDepatureDate()!=null && newFlight.getDepatureDate()>-1 && !Objects.equals(flight.getDepatureDate(),newFlight.getDepatureDate()))
			flight.setDepatureDate(newFlight.getDepatureDate());
		if(newFlight.getDepatureMonth()!=null && newFlight.getDepatureMonth()>-1 && !Objects.equals(flight.getDepatureMonth(),newFlight.getDepatureMonth()))
			flight.setDepatureMonth(newFlight.getDepatureMonth());
		if(newFlight.getDepatureYear()!=null && newFlight.getDepatureYear()>-1 && !Objects.equals(flight.getDepatureYear(),newFlight.getDepatureYear()))
			flight.setDepatureYear(newFlight.getDepatureYear());
		if(newFlight.getDepatureLocation()!=null && newFlight.getDepatureLocation().length()>0 && !Objects.equals(flight.getDepatureLocation(),newFlight.getDepatureLocation()))
			flight.setDepatureLocation(newFlight.getDepatureLocation());
	}
}
