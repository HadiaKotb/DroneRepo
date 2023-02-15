package com.drones.drone.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.drones.drone.enums.Model;
import com.drones.drone.enums.State;
import com.fasterxml.jackson.annotation.JsonManagedReference;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "drone")
@Builder

public class Drone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@Size(max = 100 ,message =" Serial number must not exceed 100 character")
	private String serialNumber;
	
	@Enumerated(EnumType.STRING)
	private Model model;
	//@Max(value = 500, message = "weight limit must not exceed 500gm")
	private int weightLimit;
	//@Size(max=4)
	private String batteryCapacity;
	@Enumerated(EnumType.STRING)
	private State state;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Medication>medications= new ArrayList<Medication>();
	
	
	  public void addMedications(List<Medication> medications) {
	        this.medications = medications;
	        medications.forEach(medication -> medication.setDrone(this));
	    }
}
