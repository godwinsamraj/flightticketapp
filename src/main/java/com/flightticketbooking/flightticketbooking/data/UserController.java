package com.flightticketbooking.flightticketbooking.data;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v3/user")
@CrossOrigin
public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService=userService;
	}
	@GetMapping
	public List<User> getUser(){
		return userService.getUser();
	}
	@GetMapping("/bookedTickets/{userEmail}")
	public List<Flight> getBookedTickets(@PathVariable("userEmail") String userEmail){
		return userService.getBookedTickets(userEmail);
	}
	@PostMapping("/add")
	public Boolean registerNewUser(@RequestBody User user) {
		return userService.addNewUser(user);
	}
	@PostMapping("/loginUser/{email}/{password}")
	public Boolean loginPerson(@ModelAttribute("user") User user) {
		return userService.loginUser(user);
	}
	@PutMapping("/bookticket/{userEmail}/{flightId}")
	public void bookTicket(@PathVariable("userEmail") String userEmail,@PathVariable("flightId") Long flightId) {
		userService.bookTicket(userEmail,flightId);
	}
	@DeleteMapping("/delete/{userId}")
	public Boolean deleteUser(@PathVariable("userId") Long userId) {
		return userService.deleteUser(userId);
	}
	@PutMapping("/update/{userName}")
	public void updatePerson(@RequestBody User newUser,@PathVariable("userName") String userName) {
		userService.updateUser(newUser,userName);
	}
}
;