package com.flightticketbooking.flightticketbooking.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Flight {
	@Id
	@SequenceGenerator(
			name="flight_sequence",
			sequenceName="flight_sequence",
			allocationSize=1
			)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="flight_sequence"
			)
	public Long getId() {
		return id;
	}
	public Flight(String name, Integer arrivalHour, Integer arrivalMinute, Integer arrivalDate, Integer arrivalMonth,
			Integer arrivalYear, String arrivalLocation, Integer depatureHour, Integer depatureMinute,
			Integer depatureDate, Integer depatureMonth, Integer depatureYear, String depatureLocation) {
		super();
		this.name = name;
		this.arrivalHour = arrivalHour;
		this.arrivalMinute = arrivalMinute;
		this.arrivalDate = arrivalDate;
		this.arrivalMonth = arrivalMonth;
		this.arrivalYear = arrivalYear;
		this.arrivalLocation = arrivalLocation;
		this.depatureHour = depatureHour;
		this.depatureMinute = depatureMinute;
		this.depatureDate = depatureDate;
		this.depatureMonth = depatureMonth;
		this.depatureYear = depatureYear;
		this.depatureLocation = depatureLocation;
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
	public Integer getArrivalHour() {
		return arrivalHour;
	}
	public void setArrivalHour(Integer arrivalHour) {
		this.arrivalHour = arrivalHour;
	}
	public Integer getArrivalMinute() {
		return arrivalMinute;
	}
	public void setArrivalMinute(Integer arrivalMinute) {
		this.arrivalMinute = arrivalMinute;
	}
	public Integer getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Integer arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Integer getArrivalMonth() {
		return arrivalMonth;
	}
	public void setArrivalMonth(Integer arrivalMonth) {
		this.arrivalMonth = arrivalMonth;
	}
	public Integer getArrivalYear() {
		return arrivalYear;
	}
	public void setArrivalYear(Integer arrivalYear) {
		this.arrivalYear = arrivalYear;
	}
	public Integer getDepatureHour() {
		return depatureHour;
	}
	public void setDepatureHour(Integer depatureHour) {
		this.depatureHour = depatureHour;
	}
	public Integer getDepatureMinute() {
		return depatureMinute;
	}
	public void setDepatureMinute(Integer depatureMinute) {
		this.depatureMinute = depatureMinute;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", name=" + name + ", arrivalHour=" + arrivalHour + ", arrivalMinute="
				+ arrivalMinute + ", arrivalDate=" + arrivalDate + ", arrivalMonth=" + arrivalMonth + ", arrivalYear="
				+ arrivalYear + ", arrivalLocation=" + arrivalLocation + ", depatureHour=" + depatureHour
				+ ", depatureMinute=" + depatureMinute + ", depatureDate=" + depatureDate + ", depatureMonth="
				+ depatureMonth + ", depatureYear=" + depatureYear + ", depatureLocation=" + depatureLocation + "]";
	}
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public String getDepatureLocation() {
		return depatureLocation;
	}
	public void setDepatureLocation(String depatureLocation) {
		this.depatureLocation = depatureLocation;
	}
	public Integer getDepatureDate() {
		return depatureDate;
	}
	public void setDepatureDate(Integer depatureDate) {
		this.depatureDate = depatureDate;
	}
	public Integer getDepatureMonth() {
		return depatureMonth;
	}
	public void setDepatureMonth(Integer depatureMonth) {
		this.depatureMonth = depatureMonth;
	}
	public Flight(String name, Integer arrivalHour, Integer arrivalMinute, Integer arrivalDate, Integer arrivalMonth,
			Integer arrivalYear, String arrivalLocation, Integer depatureHour, Integer depatureMinute,
			Integer depatureDate, Integer depatureMonth, Integer depatureYear, String depatureLocation,
			String bookedTickets) {
		super();
		this.name = name;
		this.arrivalHour = arrivalHour;
		this.arrivalMinute = arrivalMinute;
		this.arrivalDate = arrivalDate;
		this.arrivalMonth = arrivalMonth;
		this.arrivalYear = arrivalYear;
		this.arrivalLocation = arrivalLocation;
		this.depatureHour = depatureHour;
		this.depatureMinute = depatureMinute;
		this.depatureDate = depatureDate;
		this.depatureMonth = depatureMonth;
		this.depatureYear = depatureYear;
		this.depatureLocation = depatureLocation;
		this.bookedTickets = bookedTickets;
	}
	public Flight(Long id, String name, Integer arrivalHour, Integer arrivalMinute, Integer arrivalDate,
			Integer arrivalMonth, Integer arrivalYear, String arrivalLocation, Integer depatureHour,
			Integer depatureMinute, Integer depatureDate, Integer depatureMonth, Integer depatureYear,
			String depatureLocation, String bookedTickets) {
		super();
		this.id = id;
		this.name = name;
		this.arrivalHour = arrivalHour;
		this.arrivalMinute = arrivalMinute;
		this.arrivalDate = arrivalDate;
		this.arrivalMonth = arrivalMonth;
		this.arrivalYear = arrivalYear;
		this.arrivalLocation = arrivalLocation;
		this.depatureHour = depatureHour;
		this.depatureMinute = depatureMinute;
		this.depatureDate = depatureDate;
		this.depatureMonth = depatureMonth;
		this.depatureYear = depatureYear;
		this.depatureLocation = depatureLocation;
		this.bookedTickets = bookedTickets;
	}
	public String getBookedTickets() {
		return bookedTickets;
	}
	public void setBookedTickets(String bookedTickets) {
		this.bookedTickets = bookedTickets;
	}
	public Integer getDepatureYear() {
		return depatureYear;
	}
	public void setDepatureYear(Integer depatureYear) {
		this.depatureYear = depatureYear;
	}
	private Long id;
	private String name;
	private Integer arrivalHour;
	private Integer arrivalMinute;
	private Integer arrivalDate;
	private Integer arrivalMonth;
	private Integer arrivalYear;
	private String arrivalLocation;
	private Integer depatureHour;
	private Integer depatureMinute;
	private Integer depatureDate;
	private Integer depatureMonth;
	private Integer depatureYear;
	private String depatureLocation;
	private String bookedTickets;
	public Flight() {}

}
