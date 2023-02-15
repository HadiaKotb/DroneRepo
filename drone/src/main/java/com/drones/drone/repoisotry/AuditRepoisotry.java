package com.drones.drone.repoisotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drones.drone.entities.Audit;

public interface AuditRepoisotry extends JpaRepository<Audit, Integer> {

}
