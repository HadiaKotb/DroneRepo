package com.drones.drone.service.implementation;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drones.drone.Utils.ValidateDigits;
import com.drones.drone.entities.Drone;
import com.drones.drone.enums.Model;
import com.drones.drone.enums.State;
import com.drones.drone.exception.BatteryLimitException;
import com.drones.drone.repoisotry.DroneRepoisotry;
import com.drones.drone.service.DroneService;



@Service
public class DroneServiceImplementation implements DroneService {
	@Autowired
	DroneRepoisotry droneRepo;

//	@Autowired
	//Validator validator;

	@Override
	public Drone save(Drone drone)  {
		// TODO Auto-generated method stub

		
		if (drone.getBatteryCapacity() != null
				&& Integer.parseInt(ValidateDigits.validateDigitInString(drone.getBatteryCapacity())) < 25
				&& State.LOADING==drone.getState()) {
			throw new BatteryLimitException("Battery must be greater than 25% in order to be in a loading state");

		}
		 drone.addMedications(drone.getMedications()); 

		return droneRepo.save(drone);
	}

	@Override
	public Optional<Drone> findById(Integer id) {
		// TODO Auto-generated method stub
		return droneRepo.findById(id);
	}

	@Override
	public List<Drone> findAllAvailableDronesWithLoadingState() {
		// TODO Auto-generated method stub
		return droneRepo.findAllLoadingDrone();
	}

}
