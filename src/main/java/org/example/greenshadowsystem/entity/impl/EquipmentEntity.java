package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private Enum status;
    @OneToMany(mappedBy = "equipment")
    private List<FieldEquipment> fieldEquipments;
    @OneToMany(mappedBy = "equipment")
    private List<StaffEquipment> staffEquipments;
}
