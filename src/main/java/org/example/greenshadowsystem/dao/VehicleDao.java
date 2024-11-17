package org.example.greenshadowsystem.dao;

import org.example.greenshadowsystem.entity.impl.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface VehicleDao extends JpaRepository<VehicleEntity,String> {
}
