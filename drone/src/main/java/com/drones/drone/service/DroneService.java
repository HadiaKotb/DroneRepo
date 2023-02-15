package com.drones.drone.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import com.drones.drone.entities.Drone;

public interface DroneService {
	

	Drone save(Drone Drone);
	  
	Optional<Drone> findById(Integer id);
	
	List<Drone> findAllAvailableDronesWithLoadingState();
	 

	

}
