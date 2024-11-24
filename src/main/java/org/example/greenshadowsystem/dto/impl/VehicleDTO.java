package org.example.greenshadowsystem.dto.impl;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.VehicleStatus;
import org.example.greenshadowsystem.entity.Availability;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO implements VehicleStatus {
    private String vehicleCode;
    private String licensePlateNum;
    private String category;
    private Double fuelType;
    @Enumerated(EnumType.STRING)
    private Availability status;
}
