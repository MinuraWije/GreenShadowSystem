package org.example.greenshadowsystem.service;


import org.example.greenshadowsystem.dto.VehicleStatus;
import org.example.greenshadowsystem.dto.impl.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO vehicleDTO);
    List<VehicleDTO> getAllVehicles();
    VehicleStatus getVehicle(String vehicleDTO);
    void deleteVehicle(String vehicleId);
    void updateVehicle(String vehicleID,VehicleDTO vehicleDTO);

}
