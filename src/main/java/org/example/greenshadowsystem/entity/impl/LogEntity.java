package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.SuperEntity;

import java.util.Date;

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
}
