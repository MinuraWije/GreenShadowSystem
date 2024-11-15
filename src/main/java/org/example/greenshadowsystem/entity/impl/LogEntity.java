package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.SuperEntity;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "log")
public class LogEntity implements SuperEntity {
    @Id
    private String logCode;
    private String logDetails;
    private Date logDate;
    @Column(columnDefinition = "LONGTEXT")
    private String observedImg;
    @OneToMany(mappedBy = "log")
    private List<CropEntity> cropLogs;
    @OneToMany(mappedBy = "log")
    private List<FieldEntity> fieldLogs;
    @OneToMany(mappedBy = "log")
    private List<StaffEntity> staffLogs;
}
