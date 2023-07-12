package com.flightticketbooking.flightticketbooking.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Admin {
	@Id
	@SequenceGenerator(
			name="admin_sequence",
			sequenceName="admin_sequence",
			allocationSize=1
			)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="admin_sequence"
			)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String adminCode;
	public Admin() {}
	public Admin(Long id, String name, String email, String password, String adminCode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.adminCode = adminCode;
	}
	public Admin(String name, String email, String password, String adminCode) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.adminCode = adminCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", adminCode="
				+ adminCode + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	
}
