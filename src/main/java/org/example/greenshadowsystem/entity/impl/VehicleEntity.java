package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.Availability;
import org.example.greenshadowsystem.entity.SuperEntity;

import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private Availability status;
    @OneToMany(mappedBy = "vehicle")
    private List<StaffVehicle> staffVehicles;
}
