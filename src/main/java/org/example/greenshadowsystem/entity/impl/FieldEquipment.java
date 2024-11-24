package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.Availability;
import org.example.greenshadowsystem.entity.SuperEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "field_equipment")
public class FieldEquipment implements SuperEntity {
    @EmbeddedId
    private FieldEquipmentID fieldEquipmentID;
    @Enumerated(EnumType.STRING)
    private Availability status;
    @ManyToOne
    @MapsId("equipmentId")
    @JoinColumn(name = "equipmentId", referencedColumnName = "equipmentId")
    private EquipmentEntity equipment;
    @ManyToOne
    @MapsId("fieldCode")
    @JoinColumn(name = "fieldCode", referencedColumnName = "fieldCode")
    private FieldEntity field;
}
