package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.SuperEntity;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff_vehicle")
public class StaffVehicle implements SuperEntity {
    @EmbeddedId
    private StaffVehicleID staffVehicleID;
    private Date assignedDate;
    @Enumerated(EnumType.STRING)
    private Availability status;
    @ManyToOne
    @MapsId("staffId")
    @JoinColumn(name = "staffId", referencedColumnName = "staffId")
    private StaffEntity staff;
    @ManyToOne
    @MapsId("vehicleCode")
    @JoinColumn(name = "vehicleCode", referencedColumnName = "vehicleCode")
    private VehicleEntity vehicle;
}
