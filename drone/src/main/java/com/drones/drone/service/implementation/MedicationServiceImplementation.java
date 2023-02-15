package com.drones.drone.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.drones.drone.entities.Medication;

import com.drones.drone.repoisotry.MedicationRepoisotry;
import com.drones.drone.service.MedicationService;
@Service
public class MedicationServiceImplementation implements MedicationService {

	@Autowired
	MedicationRepoisotry medicationRepo;
	@Override
	public List<Medication> findAllAvailableMedicationWithLoadedState(Integer id) {
		// TODO Auto-generated method stub
		return medicationRepo.findAllLoadedMedication(id);
	}

}
