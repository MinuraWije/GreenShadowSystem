package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.SuperEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class EquipmentEntity implements SuperEntity {
    @Id
    private String equipmentId;
    private String name;
    private String type;
    @Enumerated(EnumType.STRING)
    private Availability status;
    @OneToMany(mappedBy = "equipment")
    private List<FieldEquipment> fieldEquipments;
    @OneToMany(mappedBy = "equipment")
    private List<StaffEquipment> staffEquipments;
}
