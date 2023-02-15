package com.drones.drone.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.drones.drone.dto.DroneDto;
import com.drones.drone.dto.MedicationDto;
import com.drones.drone.entities.Drone;
import com.drones.drone.entities.Medication;
import com.drones.drone.exception.InvalidRequestException;
import com.drones.drone.exception.ResourceNotFoundException;
import com.drones.drone.mapper.DroneMapper;
import com.drones.drone.mapper.MedicationMapper;
import com.drones.drone.service.DroneService;
import com.drones.drone.service.MedicationService;




@RestController
public class DroneController {
	
	@Autowired
	DroneService droneService;
	
	@Autowired
	DroneMapper droneMapper;

	
	@PostMapping(value="/drone")
	DroneDto saveDrone( @Valid @RequestBody  DroneDto droneDto,BindingResult bindingResult) throws IOException {
		
		if (bindingResult.hasErrors()) {
			String errorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
			throw new InvalidRequestException(errorMessage);
		}
		
		
		Drone drone = droneMapper.mapDroneDtoToDrone(droneDto);


		Drone savedDrone = droneService.save(drone);

		return droneMapper.mapDroneToDroneDto(savedDrone);
	}
	
	@GetMapping("/drone/{id}")
	ResponseEntity<DroneDto> findById(@PathVariable Integer id) {
		
		Drone drone = droneService.findById(id).orElseThrow(() -> new ResourceNotFoundException("drone not found : " + id));
		DroneDto droneDto = droneMapper.mapDroneToDroneDto(drone);
		return ResponseEntity.ok().body(droneDto);
	}
	
	
	@GetMapping("/drone/loading")
	ResponseEntity<List<DroneDto>> findAllLoadingDrone() {
		
		List<Drone> drone = droneService.findAllAvailableDronesWithLoadingState();
		if(drone.isEmpty())
			throw new ResourceNotFoundException("No avialable drone with loading state" );
		
		return ResponseEntity.ok().body(droneMapper.mapDroneListToDroneDtoList(drone));
	}
	
	@GetMapping("/battery/{id}")
	ResponseEntity<String> findBatteryLevelForGivernDrone(@PathVariable Integer id) {
		
		Drone drone = droneService.findById(id).orElseThrow(() -> new ResourceNotFoundException("drone not found : " + id));
		
		return ResponseEntity.ok().body(droneMapper.mapDroneToDroneDto(drone).getBatteryCapacity());
	}

}
