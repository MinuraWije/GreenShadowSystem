package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.SuperEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehicles")
public class VehicleEntity implements SuperEntity {
    @Id
    private String vehicleCode;
    private String licensePlateNum;
    private String category;
    private Double fuelType;
    private Enum status;
}
