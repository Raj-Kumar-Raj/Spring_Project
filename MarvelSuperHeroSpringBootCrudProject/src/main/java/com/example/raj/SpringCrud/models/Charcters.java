package com.example.raj.SpringCrud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Charcters {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHumanName() {
		return humanName;
	}
	public void setHumanName(String humanName) {
		this.humanName = humanName;
	}
private String name;
 private String humanName;
}
