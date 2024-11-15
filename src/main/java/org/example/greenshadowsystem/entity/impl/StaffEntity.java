package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.SuperEntity;
import org.springframework.data.geo.Point;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity implements SuperEntity {
    @Id
    private String staffId;
    private String name;
    private Enum role;
    private String designation;
    private Point gender;
    private Date joinedDate;
    private String email;
    private Date dob;
    private String address;
    private String contactNum;
    @OneToMany(mappedBy = "staff")
    private List<FieldedStaff> fieldedStaffs;
    @OneToMany(mappedBy = "staff")
    private List<StaffVehicle> staffVehicles;
    @OneToMany(mappedBy = "staff")
    private List<StaffEquipment> staffEquipments;
    @OneToMany(mappedBy = "staff")
    private List<StaffLog> staffLogs;
}
