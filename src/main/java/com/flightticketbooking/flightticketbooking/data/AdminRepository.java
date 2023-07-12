package com.flightticketbooking.flightticketbooking.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	Optional<Admin> findAdminByEmail(String email);
	Optional<Admin> findAdminByName(String adminName);
}
