package com.drones.drone.scheduler;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.drones.drone.entities.Audit;
import com.drones.drone.repoisotry.AuditRepoisotry;
import com.drones.drone.repoisotry.DroneRepoisotry;

@Configuration
@EnableScheduling
public class ShedularJob {
	@Autowired
	AuditRepoisotry auditrepo;
	@Autowired
	DroneRepoisotry droneRepo;
	
	@Scheduled(fixedRate = 10000)
	public void scheduleFixedRateTask() {
	    List<String>batteriesCpacity=droneRepo.findBatteryCapicityForDrones();
	    
	    for (String battery : batteriesCpacity) {
	    	
	    	Audit audit = new Audit();
	    	audit.setBattery(battery);
	    	audit.setCreationDate(OffsetDateTime.now());
	    	auditrepo.save(audit);
	    }
	}

}
