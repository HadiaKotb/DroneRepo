package com.drones.drone.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.drones.drone.dto.DroneDto;
import com.drones.drone.entities.Drone;
import com.drones.drone.entities.Medication;

@Mapper(componentModel = "spring", uses = MedicationMapper.class)
public interface DroneMapper {

	@Mapping(target = "medications")
	Drone mapDroneDtoToDrone(DroneDto droneDto);

	DroneDto mapDroneToDroneDto(Drone drone);

	List<DroneDto> mapDroneListToDroneDtoList(List<Drone> drone);
	
	 default Drone fromId(Integer id) {
	        if (id == null) {
	            return null;
	        }
	        Drone entity = new Drone();
	        entity.setId(id);
	        return entity;
	    }

	    default Integer toId(Drone droneEntity) {
	        if (droneEntity == null){
	            return null;
	        }
	        return droneEntity.getId();
	    }

	

	 
}
