package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.Availability;
import org.example.greenshadowsystem.entity.SuperEntity;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff_equipment")
public class StaffEquipment implements SuperEntity {
    @EmbeddedId
    private StaffEquipmentID staffEquipmentID;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Availability status;
    @ManyToOne
    @MapsId("staffId")
    @JoinColumn(name = "staffId", referencedColumnName = "staffId")
    private StaffEntity staff;
    @ManyToOne
    @MapsId("equipmentId")
    @JoinColumn(name = "equipmentId", referencedColumnName = "equipmentId")
    private EquipmentEntity equipment;
}
