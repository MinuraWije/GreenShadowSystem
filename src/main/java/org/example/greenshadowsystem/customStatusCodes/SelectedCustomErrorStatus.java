package org.example.greenshadowsystem.customStatusCodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.VehicleStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCustomErrorStatus implements VehicleStatus{
    private int statusCode;
    private String statusMessage;
}
