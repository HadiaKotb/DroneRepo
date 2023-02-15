package com.drones.drone.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.drones.drone.enums.Model;
import com.drones.drone.enums.State;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


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
@Table(name="medication")
@Builder
public class Medication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@Pattern(regexp ="^[a-zA-Z0-9_-]*$" ,message = " name allows only uppercase, lowercase, _ and -")
	private String name;
	
	private int weight;
	
	private String code;
	
 	
    private String image;
 	
	
	  @ManyToOne(fetch=FetchType.LAZY)
	  @JsonIgnore
	  @JoinColumn(name = "drone_Id", nullable=false)
	  private Drone drone;
	 
 	
 	
 	

}
