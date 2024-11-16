package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.StaffEquipmentStatus;
import org.example.greenshadowsystem.entity.impl.Availability;
import org.example.greenshadowsystem.entity.impl.StaffEquipmentID;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffEquipmentDTO implements StaffEquipmentStatus {
    private StaffEquipmentID staffEquipmentID;
    private Date date;
    private Availability status;
    private StaffDTO staff;
    private EquipmentDTO equipment;
}
