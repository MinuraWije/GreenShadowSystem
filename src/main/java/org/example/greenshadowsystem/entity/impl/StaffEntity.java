package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.Gender;
import org.example.greenshadowsystem.entity.Role;
import org.example.greenshadowsystem.entity.SuperEntity;
import org.springframework.data.geo.Point;

import java.time.LocalDate;
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
    @Enumerated(EnumType.STRING)
    private Role role;
    private String designation;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate joinedDate;
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
