package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.StaffStatus;
import org.example.greenshadowsystem.entity.Gender;
import org.example.greenshadowsystem.entity.Role;
import org.springframework.data.geo.Point;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO implements StaffStatus {
    private String staffId;
    private String name;
    private Role role;
    private String designation;
    private Gender gender;
    private LocalDate joinedDate;
    private String email;
    private Date dob;
    private String address;
    private String contactNum;
    private List<FieldedStaffDTO> fieldedStaffs;
    private List<StaffVehicleDTO> staffVehicles;
    private List<StaffEquipmentDTO> staffEquipments;
    private List<StaffLogDTO> staffLogs;
}
