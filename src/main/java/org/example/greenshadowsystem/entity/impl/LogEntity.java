package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.SuperEntity;

import java.time.LocalDate;
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
    private String logDate;
    @Column(columnDefinition = "LONGTEXT")
    private String observedImg;
    @OneToMany(mappedBy = "log")
    private List<CropLog> cropLogs;
    @OneToMany(mappedBy = "log")
    private List<FieldLog> fieldLogs;
    @OneToMany(mappedBy = "log")
    private List<StaffLog> staffLogs;
}
