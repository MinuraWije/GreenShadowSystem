package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.StaffVehicleStatus;
import org.example.greenshadowsystem.entity.Availability;
import org.example.greenshadowsystem.entity.impl.StaffVehicleID;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffVehicleDTO implements StaffVehicleStatus {
    private StaffVehicleID staffVehicleID;
    private Date assignedDate;
    private Availability status;
    private StaffDTO staff;
    private VehicleDTO vehicle;
}
