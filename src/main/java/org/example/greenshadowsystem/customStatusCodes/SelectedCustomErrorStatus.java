package org.example.greenshadowsystem.customStatusCodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCustomErrorStatus implements VehicleStatus, StaffStatus, EquipmentStatus, FieldStatus, LogStatus, CropStatus {
    private int statusCode;
    private String statusMessage;
}
