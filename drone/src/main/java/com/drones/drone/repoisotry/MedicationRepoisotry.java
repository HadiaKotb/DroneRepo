package com.drones.drone.repoisotry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.drones.drone.entities.Drone;
import com.drones.drone.entities.Medication;



@Repository
public interface MedicationRepoisotry extends JpaRepository<Medication,Integer> {

	@Query("SELECT m FROM Medication m WHERE m.drone.id = (SELECT  d.id FROM Drone d WHERE d.id  =(?1)and d.state = 'LOADED') ")
	List<Medication> findAllLoadedMedication(Integer id);


}
