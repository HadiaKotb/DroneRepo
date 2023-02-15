package com.drones.drone.dto;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import com.drones.drone.entities.Drone;
import com.drones.drone.entities.Medication;
import com.drones.drone.enums.Model;
import com.drones.drone.enums.State;
import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationDto {
	private int id;
	
	@Pattern(regexp ="^[a-zA-Z0-9_-]*$" ,message = " name allows only uppercase, lowercase, _ and -")
	private String name;
	
	private int weight;
	@Pattern(regexp ="^[A-Z0-9_]*$" ,message = " code allows only uppercase,_ and numbers")
	private String code;
	
 
    private String image;
 	
 
    
	 private DroneDto drone; 
}
