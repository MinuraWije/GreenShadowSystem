package org.example.greenshadowsystem.dto.impl;

import org.example.greenshadowsystem.dto.FieldedStaffStatus;
import org.example.greenshadowsystem.entity.impl.Availability;
import org.example.greenshadowsystem.entity.impl.FieldEntity;
import org.example.greenshadowsystem.entity.impl.FieldedStaffID;
import org.example.greenshadowsystem.entity.impl.StaffEntity;

import java.util.Date;

public class FieldedStaffDTO implements FieldedStaffStatus {
    private FieldedStaffID fieldedStaffID;
    private Date date;
    private Availability status;
    private StaffEntity staff;
    private FieldEntity field;
}
