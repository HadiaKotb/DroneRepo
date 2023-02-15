package com.drones.drone.entities;

import java.time.OffsetDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.drones.drone.enums.Model;
import com.drones.drone.enums.State;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "audit")
public class Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String battery;
	
	@CreatedDate
	@Column(name = "creation_date", nullable = false, updatable = false)
	private OffsetDateTime creationDate;

}
