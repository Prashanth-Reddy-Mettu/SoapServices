package com.prashanth.spring.soap.api.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "alarm")
public class Alarm {
	@Id
	@Column(name="id")
	private String id;
	@Column(name="equipment")
	private String equipment;
	@Column(name="dateAndTime")
	private LocalDateTime dateAndTime;
	@Column(name="description")
	private String description;
	public Alarm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alarm(String id, String equipment, LocalDateTime dateAndTime, String description) {
		super();
		this.id = id;
		this.equipment = equipment;
		this.dateAndTime = dateAndTime;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
