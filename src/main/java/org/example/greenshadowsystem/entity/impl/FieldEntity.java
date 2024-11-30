package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.SuperEntity;
import org.springframework.data.geo.Point;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "field")
public class FieldEntity implements SuperEntity {
    @Id
    private String fieldCode;
    private String fieldName;
    @Column(columnDefinition = "POINT")
    private Point location;
    private Double size;
    @Column(columnDefinition = "LONGTEXT")
    private String img1;
    @Column(columnDefinition = "LONGTEXT")
    private String img2;
    @OneToMany(mappedBy = "field")
    private List<CropEntity> crops;
    @OneToMany(mappedBy = "field")
    private List<FieldedStaff> fieldedStaffs;
    @OneToMany(mappedBy = "field")
    private List<FieldEquipment> fieldEquipments;
    @OneToMany(mappedBy = "field")
    private List<FieldLog> fieldLogs;
}
