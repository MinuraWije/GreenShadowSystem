package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.SuperEntity;
import org.springframework.data.geo.Point;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "equipment")
public class FieldEntity implements SuperEntity {
    @Id
    private String fieldCode;
    private String fieldName;
    private Point location;
    private Double size;
    @Column(columnDefinition = "LONGTEXT")
    private String img1;
    @Column(columnDefinition = "LONGTEXT")
    private String img2;
}
