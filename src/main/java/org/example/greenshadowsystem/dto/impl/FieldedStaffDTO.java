package org.example.greenshadowsystem.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.FieldedStaffStatus;
import org.example.greenshadowsystem.entity.impl.Availability;
import org.example.greenshadowsystem.entity.impl.FieldedStaffID;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldedStaffDTO implements FieldedStaffStatus {
    private FieldedStaffID fieldedStaffID;
    private Date date;
    private Availability status;
    private StaffDTO staff;
    private FieldDTO field;
}
