package org.example.greenshadowsystem.customStatusCodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.EquipmentStatus;
import org.example.greenshadowsystem.dto.StaffStatus;
import org.example.greenshadowsystem.dto.VehicleStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCustomErrorStatus implements VehicleStatus, StaffStatus, EquipmentStatus {
    private int statusCode;
    private String statusMessage;
}
