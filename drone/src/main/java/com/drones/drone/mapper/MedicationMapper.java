package com.drones.drone.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.drones.drone.dto.DroneDto;
import com.drones.drone.dto.MedicationDto;
import com.drones.drone.entities.Drone;
import com.drones.drone.entities.Medication;
@Mapper(componentModel = "spring",uses = {DroneMapper.class})
public interface MedicationMapper {
	
	Medication mapMedicationDtoToMedication(MedicationDto medication);
	@Mapping(target = "drone", ignore=true)
	MedicationDto mapMedicationToMedicationDto(Medication medication);
	List<MedicationDto> mapMedicationToMedicationDto(List<Medication> medication);
	
	
	@AfterMapping
	default void mapMedicationAttributes(Medication source, @MappingTarget MedicationDto.MedicationDtoBuilder target) {
		target.drone(DroneDto.builder().id(source.getDrone().getId()).serialNumber(source.getDrone().getSerialNumber())
				.model(source.getDrone().getModel()).state(source.getDrone().getState()).medications(new ArrayList<>())
				.batteryCapacity(source.getDrone().getBatteryCapacity()).weightLimit(source.getDrone().getWeightLimit())
				.build());
	}
	 

	 
}
