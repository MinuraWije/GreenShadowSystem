package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.EquipmentStatus;
import org.example.greenshadowsystem.entity.Availability;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDTO implements EquipmentStatus {
    private String equipmentId;
    private String name;
    private String type;
    private Availability status;
    private List<FieldEquipmentDTO> fieldEquipments;
    private List<StaffEquipmentDTO> staffEquipments;
}
