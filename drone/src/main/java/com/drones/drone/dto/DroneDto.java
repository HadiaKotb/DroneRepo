package com.drones.drone.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.drones.drone.entities.Medication;
import com.drones.drone.enums.Model;
import com.drones.drone.enums.State;

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
public class DroneDto {
	
	private int id;
	
	@Size(max = 100 ,message =" Serial number must not exceed 100 character")
	private String serialNumber;
	
	
	private Model model;
	
	@Max(value = 500, message = "weight limit must not exceed 500gm")
	private int weightLimit;
	@Size(max=4)
	@Pattern(regexp ="^[0-9%]*$" ,message = "battery capaicty must be in like 70% ")
	private String batteryCapacity;

	private State state;
	@Valid
	private List<MedicationDto>medications= new ArrayList<MedicationDto>();
	
	  public void addMedications(MedicationDto medication) {
		  
		  if(medications== null) {
			  medications=new ArrayList<MedicationDto>();
		  }
	       
	       this.medications.add(medication);
	    }
}
