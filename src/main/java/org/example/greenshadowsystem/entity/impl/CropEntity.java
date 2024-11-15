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
@Table(name = "crop")
public class CropEntity implements SuperEntity {
    @Id
    private String cropCode;
    private String cropName;
    private String cropScientificName;
    private String category;
    @Column(columnDefinition = "LONGTEXT")
    private String img;
    private String season;
    @ManyToOne
    @JoinColumn(name = "fieldCode", nullable = false)
    private FieldEntity field;
    @OneToMany(mappedBy = "crop")
    private List<LogEntity> cropLogs;
}
