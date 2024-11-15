package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class StaffEquipmentID {
    private String staffId;
    private String equipmentId;
}
