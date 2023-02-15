package com.drones.drone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.drones.drone.dto.MedicationDto;
import com.drones.drone.entities.Drone;
import com.drones.drone.entities.Medication;
import com.drones.drone.exception.ResourceNotFoundException;
import com.drones.drone.mapper.DroneMapper;
import com.drones.drone.mapper.MedicationMapper;
import com.drones.drone.service.DroneService;
import com.drones.drone.service.MedicationService;

@RestController
public class MedicationController {
	@Autowired
	DroneService droneService;

	
	@Autowired
	MedicationMapper medicationMapper;
	
	@Autowired
	MedicationService medervice;
	
	@GetMapping("/drone/medications/{id}")
	ResponseEntity<List<MedicationDto>> findAllMedicationsById(@PathVariable Integer id) {
		
		Drone drone = droneService.findById(id).orElseThrow(() -> new ResourceNotFoundException("drone not found : " + id));
		
		if(drone.getMedications().isEmpty())
			throw new ResourceNotFoundException("No Medication found for given drone");
		
		return ResponseEntity.ok().body(medicationMapper.mapMedicationToMedicationDto(drone.getMedications()));
	}
	
	@GetMapping("/drone/loaded/medications/{id}")
	ResponseEntity<List<MedicationDto>> findAllLoadedMedicationsById(@PathVariable Integer id) {
		
		List<Medication> medications = medervice.findAllAvailableMedicationWithLoadedState(id);
		if(medications.isEmpty())
				 throw new ResourceNotFoundException(" No Medication Found with loaded stat");
		
		return ResponseEntity.ok().body(medicationMapper.mapMedicationToMedicationDto(medications));
	}
}
