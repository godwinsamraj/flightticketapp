package com.flightticketbooking.flightticketbooking.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final FlightRepository flightRepository;
	public UserService(UserRepository userRepository,FlightRepository flightRepository) {
		this.userRepository=userRepository;
		this.flightRepository=flightRepository;
	}
	public List<User> getUser() {
		return userRepository.findAll();
	}
	public Boolean addNewUser(User user) {
		Optional<User> userOptional=userRepository.findUserByEmail(user.getEmail());
		if(userOptional.isPresent()) return false;
		userRepository.save(user);
		return true;
	}
	public Boolean deleteUser(Long userId) {
		if(!userRepository.existsById(userId)) return false;
		userRepository.deleteById(userId);
		return true;
	}
	@Transactional
	public void updateUser(User newUser, String userName) {
		User user=userRepository.findUserByName(userName)
				.orElseThrow(()->new IllegalStateException("user with name:"+userName+"does not exists"));
		if(newUser.getName()!=null && newUser.getName().length()>0 && !Objects.equals(newUser.getName(),user.getName()))
			user.setName(newUser.getName());
		if(newUser.getAge()!=null && newUser.getAge()>0 && !Objects.equals(user.getAge(),user.getAge()))
			user.setAge(newUser.getAge());
		if(newUser.getPhone()!=null && newUser.getPhone()>0 && !Objects.equals(user.getPhone(),user.getPhone()))
			user.setPhone(newUser.getPhone());
		if(newUser.getEmail()!=null && newUser.getEmail().length()>0 && !Objects.equals(newUser.getEmail(),user.getEmail()))
			user.setEmail(newUser.getEmail());
		if(newUser.getPassword()!=null && newUser.getPassword().length()>0 && !Objects.equals(newUser.getPassword(),user.getPassword()))
			user.setPassword(newUser.getPassword());
	}
	public Boolean loginUser(User user) {
		String userEmail=user.getEmail();
		Optional<User> userData=userRepository.findUserByEmail(userEmail);
		try {if(user.getPassword().equals(userData.get().getPassword()))return true;}
		catch(Exception e) {}
		return false;
	}
	@Transactional
	public void bookTicket(String userEmail, Long flightId) {
		Optional<User> userData=userRepository.findUserByEmail(userEmail);
		Flight flight=flightRepository.findFlightById(flightId);
		if(userData.get().getBookedTickets()==null) userData.get().setBookedTickets(String.valueOf(flightId));
		else userData.get().setBookedTickets(userData.get().getBookedTickets()+"-"+flightId);
		if(flight.getBookedTickets()==null) flight.setBookedTickets(String.valueOf(userData.get().getId()));
		else flight.setBookedTickets(flight.getBookedTickets()+"-"+userData.get().getId());
	}
	public List<Flight> getBookedTickets(String userEmail) {
		List<Flight> list=new ArrayList<Flight>();
		Optional<User> userData=userRepository.findUserByEmail(userEmail);
		String[] arr=userData.get().getBookedTickets().split("[-]+");
		for(int i=0;i<arr.length;i++) list.add(flightRepository.findFlightById(Long.parseLong(arr[i])));
		return list;
	}
}
