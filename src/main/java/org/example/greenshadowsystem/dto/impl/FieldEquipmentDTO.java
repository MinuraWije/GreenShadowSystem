package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.FieldEquipmentStatus;
import org.example.greenshadowsystem.entity.Availability;
import org.example.greenshadowsystem.entity.impl.FieldEquipmentID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldEquipmentDTO implements FieldEquipmentStatus {
    private FieldEquipmentID fieldEquipmentID;
    private Availability status;
    private EquipmentDTO equipment;
    private FieldDTO field;
}
