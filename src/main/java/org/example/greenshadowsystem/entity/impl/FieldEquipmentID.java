package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class FieldEquipmentID {
    private String fieldCode;
    private String equipmentId;
}
