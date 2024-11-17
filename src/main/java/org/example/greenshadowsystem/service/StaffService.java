package org.example.greenshadowsystem.service;

import org.example.greenshadowsystem.dto.StaffStatus;
import org.example.greenshadowsystem.dto.impl.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO);
    List<StaffDTO> getAllStaff();
    StaffStatus getStaff(String staffDTO);
    void deleteStaff(String staffId);
    void updateStaff(String staffId,StaffDTO staffDTO);
}
