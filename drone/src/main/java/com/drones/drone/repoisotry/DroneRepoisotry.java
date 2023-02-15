package com.drones.drone.repoisotry;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.drones.drone.entities.Drone;

@Repository
public interface DroneRepoisotry  extends JpaRepository<Drone,Integer> {
	
	@Query("SELECT d FROM Drone d WHERE d.state = 'LOADING'")
	List<Drone> findAllLoadingDrone();
	@Query("SELECT d.batteryCapacity FROM Drone d")
	List<String> findBatteryCapicityForDrones();
}
