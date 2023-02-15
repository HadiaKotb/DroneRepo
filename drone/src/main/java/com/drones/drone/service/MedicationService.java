package com.drones.drone.service;

import java.util.List;
import java.util.Optional;

import com.drones.drone.entities.Drone;
import com.drones.drone.entities.Medication;

public interface MedicationService {

	
	List<Medication> findAllAvailableMedicationWithLoadedState(Integer id);
}
