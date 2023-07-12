package com.flightticketbooking.flightticketbooking.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findUserByName(String userName);
	User findUserById(Long userId);
	Optional<User> findUserByEmail(String userEmail);
}
