package com.flightticketbooking.flightticketbooking.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
	@Id
	@SequenceGenerator(
		name="user_sequence",
		sequenceName="user_sequence",
		allocationSize=1
			)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="user_sequence"
			)
	private Long id;
	private String name;
	private Integer age;
	private Long phone;
	private String email;
	private String password;
	private String bookedTickets;
	public User() {}
	public User(String name, Integer age, Long phone, String email, String password, String bookedTickets) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.bookedTickets = bookedTickets;
	}
	public User(Long id, String name, Integer age, Long phone, String email, String password,
			String bookedTickets) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.bookedTickets = bookedTickets;
	}
	public User(String name, Integer age, Long phone, String email, String password) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
	public String getBookedTickets() {
		return bookedTickets;
	}
	public void setBookedTickets(String bookedTickets) {
		this.bookedTickets = bookedTickets;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + "]";
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
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
	
}
